package com.example.DislinktXWS.controller;


import com.example.DislinktXWS.model.Profile;
import com.example.DislinktXWS.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @RequestMapping(value="api/profile",method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Profile> save(@RequestBody Profile profile){
        Profile savedProfile=this.profileService.save(profile);
        return new ResponseEntity<>(savedProfile, HttpStatus.CREATED);
    }

    @RequestMapping(value="api/profile",method = RequestMethod.GET,produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<Profile>> findAll(){
        List<Profile> profiles=this.profileService.findAll();
        return new ResponseEntity<>(profiles,HttpStatus.OK);
    }

    @RequestMapping(value = "api/profile/{id}",method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long id){
        Profile profileOption=this.profileService.findById(id);
        if(profileOption==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.profileService.delete(profileOption);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value="api/profile/{id}",method = RequestMethod.GET,produces= {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Profile> getById(@PathVariable Long id){
        Profile profile=this.profileService.findById(id);
        return new ResponseEntity<>(profile,HttpStatus.OK);
    }
}
