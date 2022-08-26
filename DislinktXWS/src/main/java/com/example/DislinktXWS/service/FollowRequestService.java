package com.example.DislinktXWS.service;

import com.example.DislinktXWS.model.FollowRequest;
import com.example.DislinktXWS.model.Profile;
import com.example.DislinktXWS.repository.FollowRequestRepository;
import com.example.DislinktXWS.repository.ProfileRepository;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FollowRequestService {

    @Autowired
    private FollowRequestRepository followRequestRepository;
    @Autowired
    private ProfileRepository profileRepository;

    public FollowRequest save(FollowRequest followRequest){

        List<FollowRequest> listOfAll = this.followRequestRepository.findAll();
        Long id=(long)0;
        for ( FollowRequest f:listOfAll) {
            id=f.getId();
        }
        id=id+1;
        followRequest.setId(id);
        this.followRequestRepository.save(followRequest);


        return this.followRequestRepository.save(followRequest);
    }

    public FollowRequest findById(Long id) {
        Optional<FollowRequest> opt=this.followRequestRepository.findById(id);
        if(!opt.isPresent()) {
            return null;
        }
        return opt.get();
    }

    public void delete(FollowRequest followRequest) {
        this.followRequestRepository.delete(followRequest);
    }

    public List<FollowRequest> findAll() {
        return this.followRequestRepository.findAll();
    }

    public Profile acceptRequest( FollowRequest followRequest){

        Profile profileWhoWantToFollow = this.profileRepository.findByUserUsername(followRequest.getUsernameWhoWantToFollow());
        Profile profile = this.profileRepository.findByUserUsername(followRequest.getUsername());
        followRequest.setFollowRequest(true);
        if(followRequest.isFollowRequest() == true)
        {
            if(profile.getFollowers()==null)
            {
                List list = new ArrayList();
                list.add(profileWhoWantToFollow.getId());
                profile.setFollowers(list);
            }
            else{
                profile.getFollowers().add(profileWhoWantToFollow.getId());
            }

        }
        return profileRepository.save(profile);
    }

    public List<FollowRequest> findAllFollowRequestsByFollowerUsername(String username){
        List<FollowRequest>allFollowRequest = followRequestRepository.findAll();
        List<FollowRequest>foundedFollowRequest = new ArrayList<>();

        for (FollowRequest f:allFollowRequest)
        {
            if(f.getUsername().equals(username))
            {
                foundedFollowRequest.add(f);
            }
        }
        return foundedFollowRequest;
    }
}
