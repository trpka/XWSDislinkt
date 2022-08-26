package com.example.DislinktXWS.controller;


import com.example.DislinktXWS.model.FollowRequest;
import com.example.DislinktXWS.model.Post;
import com.example.DislinktXWS.model.Profile;
import com.example.DislinktXWS.repository.ProfileRepository;
import com.example.DislinktXWS.service.FollowRequestService;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class FollowRequestController {
    @Autowired
    private FollowRequestService followRequestService;

    @RequestMapping(value="api/followRequest",method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FollowRequest> save(@RequestBody FollowRequest followRequest){
        FollowRequest savedFollowRequest=this.followRequestService.save(followRequest);
        return new ResponseEntity<>(savedFollowRequest, HttpStatus.CREATED);
    }

    @RequestMapping(value="api/followRequest",method = RequestMethod.GET,produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<FollowRequest>> findAll(){
        List<FollowRequest> followRequest=this.followRequestService.findAll();
        return new ResponseEntity<>(followRequest,HttpStatus.OK);
    }

    @RequestMapping(value = "api/followRequest/{id}",method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long id){
        FollowRequest followRequest=this.followRequestService.findById(id);
        if(followRequest==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.followRequestService.delete(followRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value="api/followRequest/{id}",method = RequestMethod.GET,produces= {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<FollowRequest> getById(@PathVariable Long id){
        FollowRequest followRequest=this.followRequestService.findById(id);
        return new ResponseEntity<>(followRequest,HttpStatus.OK);
    }

    @RequestMapping(value="api/followRequest/request",method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Profile> acceptRequest(@RequestBody FollowRequest followRequest){
        Profile savedProfile=this.followRequestService.acceptRequest(followRequest);
        return new ResponseEntity<>(savedProfile, HttpStatus.CREATED);
    }


    @RequestMapping(value="api/followRequest/profile",method = RequestMethod.GET,produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<FollowRequest>> findAllFollowRequestsByFollowerUsername(@RequestParam String username){
        List<FollowRequest> followRequest=this.followRequestService.findAllFollowRequestsByFollowerUsername(username);
        return new ResponseEntity<>(followRequest,HttpStatus.OK);
    }


}
