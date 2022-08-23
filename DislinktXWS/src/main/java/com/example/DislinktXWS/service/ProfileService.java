package com.example.DislinktXWS.service;

import com.example.DislinktXWS.model.Profile;
import com.example.DislinktXWS.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;


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

    public Profile findById(Long id) {
        Optional<Profile> opt=this.profileRepository.findById(id);
        if(!opt.isPresent()) {
            return null;
        }
        return opt.get();
    }

    public void delete(Profile profile) {
        this.profileRepository.delete(profile);
    }

    public List<Profile> findAll() {
        return this.profileRepository.findAll();
    }
}
