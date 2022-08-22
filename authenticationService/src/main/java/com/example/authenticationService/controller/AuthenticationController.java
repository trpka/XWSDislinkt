package com.example.authenticationService.controller;


import javax.servlet.http.HttpServletResponse;


import com.example.authenticationService.dto.AuthenticatedUserDTO;
import com.example.authenticationService.dto.JwtAuthenticationRequest;
import com.example.authenticationService.dto.UserRequest;
import com.example.authenticationService.dto.UserTokenState;
import com.example.authenticationService.exception.ResourceConflictException;
import com.example.authenticationService.model.User;
import com.example.authenticationService.service.UserService;
import com.example.authenticationService.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;





//kontroler zaduzen za autentifikaciju korisnika
@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

    private final TokenUtils tokenUtils;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    @Autowired
    public AuthenticationController(TokenUtils tokenUtils, UserService userService , AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
        this.tokenUtils = tokenUtils;
        this.userService = userService;
    }



    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest, HttpServletResponse response) {

        AuthenticatedUserDTO authenticatedUserDTO = new AuthenticatedUserDTO();
        User u = userService.findByKorisnicko(authenticationRequest.getKorisnicko());

        if(u!=null){

            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getKorisnicko(),
                            authenticationRequest.getPassword()));

            SecurityContext ctx = SecurityContextHolder.createEmptyContext();
            SecurityContextHolder.setContext(ctx);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            User user = (User) authentication.getPrincipal();
            String jwt = tokenUtils.generateToken(user.getUsername());
            int expiresIn = tokenUtils.getExpiredIn();
            authenticatedUserDTO = new AuthenticatedUserDTO(user.getId(), user.getRoleType(), user.getUsername(), new UserTokenState(jwt, expiresIn));
            return new ResponseEntity<>(authenticatedUserDTO, HttpStatus.OK);}
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    // Endpoint za registraciju novog korisnika
    @PostMapping("/signup")
    public ResponseEntity<User> addUser(@RequestBody UserRequest userRequest, UriComponentsBuilder ucBuilder) {

        User existUser = this.userService.findByKorisnicko(userRequest.getKorisnicko());

        if (existUser != null) {
            throw new ResourceConflictException(userRequest.getId(), "Username already exists");
        }

        User user = this.userService.save(userRequest);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
