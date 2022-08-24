package com.example.DislinktXWS.service;

import com.example.DislinktXWS.model.Profile;
import com.example.DislinktXWS.repository.ProfileRepository;
import com.example.DislinktXWS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.DislinktXWS.model.User;


import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserRepository userRepository;


    public Profile save(Profile profile){

        List<Profile> listOfAll = this.profileRepository.findAll();
        Long id=(long)0;
        for ( Profile p:listOfAll) {
            id=p.getId();
        }
        id=id+1;
        profile.setId(id);
        this.profileRepository.save(profile);


        return this.profileRepository.save(profile);
    }

    public Profile findById(Long id)
    {
        Optional<Profile> opt=this.profileRepository.findById(id);
        if(!opt.isPresent()) {
            return null;
        }
        return opt.get();
    }

    //Pretraga po Username
    public Profile getByUsername(String username)
    {
        List<Profile> all_profiles =  this.profileRepository.findAll();
        Profile searched_profile = new Profile();
        List<User> all_users = this.userRepository.findAll();

        for(Profile p : all_profiles)
        {
            if(Objects.equals(p.getUser().getUsername(), username))
            {
                searched_profile.setId(p.getId());
                searched_profile.setUser(p.getUser());
                searched_profile.setSkills(p.getSkills());
                searched_profile.setInterests(p.getInterests());
                searched_profile.setExperience(p.getExperience());
                searched_profile.setEducation(p.getEducation());
                searched_profile.setPrivate(true);
            }
        }
            return  searched_profile;


    }




    public void delete(Profile profile) {
        this.profileRepository.delete(profile);
    }

    public List<Profile> findAll() {
        return this.profileRepository.findAll();
    }
}
