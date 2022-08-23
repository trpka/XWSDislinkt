package com.example.authenticationService.service.impl;


import com.example.authenticationService.model.User;
import com.example.authenticationService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    @Autowired
    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // Funkcija koja na osnovu username-a iz baze vraca objekat User-a
    @Override
    public UserDetails loadUserByUsername(String korisn) throws UsernameNotFoundException {
        User user = userRepository.findByKorisnicko(korisn);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", korisn));
        } else {
            return user;
        }
    }

}
