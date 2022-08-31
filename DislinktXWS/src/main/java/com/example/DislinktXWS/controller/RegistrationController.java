package com.example.DislinktXWS.controller;

import com.example.DislinktXWS.DTO.RegistrationDTO;
import com.example.DislinktXWS.model.Post;
import com.example.DislinktXWS.model.User;
import com.example.DislinktXWS.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class RegistrationController
{
    @Autowired
    RegistrationService registrationService;

    @RequestMapping(value="api/registration",method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> registration(@RequestBody User user)
    {
        User savedUser=this.registrationService.registration(user);

        return new ResponseEntity("Succesfully created a new account!", HttpStatus.CREATED);
    }

    //Prikaz svi korisnika
    @RequestMapping(value="api/users",method = RequestMethod.GET,produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<User>> findAll()
    {
        List<User> users=this.registrationService.findAll();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

}
