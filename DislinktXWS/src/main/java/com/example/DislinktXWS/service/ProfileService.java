package com.example.DislinktXWS.service;

import com.example.DislinktXWS.DTO.NewFollowerDTO;
import com.example.DislinktXWS.model.Profile;
import com.example.DislinktXWS.repository.ProfileRepository;
import com.example.DislinktXWS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.DislinktXWS.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
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
                searched_profile.setPrivateProfile(true);
            }
        }
            return  searched_profile;
    }

    public Profile UpdateProfile(Profile p)
    {
        Profile editProfile = profileRepository.getById(p.getId());

        editProfile.setUser(p.getUser());
        editProfile.setEducation(p.getEducation());
        editProfile.setExperience(p.getExperience());
        editProfile.setSkills(p.getSkills());
        editProfile.setInterests(p.getInterests());
        editProfile.setPrivateProfile(p.isPrivateProfile());

        return this.profileRepository.save(editProfile);
    }
    
   public  Long FindNumber(String username)
   {
       List<Profile> all_profiles =  this.profileRepository.findAll();
       Long number;

       for(Profile p: all_profiles)
       {
           if(Objects.equals(p.getUser().getUsername(), username))
           {
               return number = p.getUser().getId();
           }
       }
          return  null;
   }





    public void delete(Profile profile) {
        this.profileRepository.delete(profile);
    }

    public List<Profile> findAll() {
        return this.profileRepository.findAll();
    }


    public Profile followProfile(NewFollowerDTO newFollowerDTO) {
        Profile followedProfile = findById(newFollowerDTO.getIdProfileUser());
        List<User> users1 = findAllFollowers(newFollowerDTO.getIdProfileUser());
        Boolean check = false;
        for(User u  :users1) {
            if (u.getId().equals(newFollowerDTO.getIdFollowerUser())) {
                check = true;

            }
        }

                if (followedProfile.isPrivateProfile() == false && check == false) {
                    if (followedProfile.getFollowers() == null) {
                        List<Long> initList = new ArrayList<>();
                        initList.add(newFollowerDTO.getIdFollowerUser());
                        followedProfile.setFollowers(initList);
                        return profileRepository.save(followedProfile);
                    } else {
                        followedProfile.getFollowers().add(newFollowerDTO.getIdFollowerUser());
                        return  profileRepository.save(followedProfile);
                    }
                } else {
                    System.out.print("profile is private");
                }

        return new Profile();//profileRepository.save(followedProfile);
    }

    public Profile findByUsername1( String username){
        List<Profile> allProfiles = this.profileRepository.findAll();

        for (Profile p:allProfiles) {
            if(p.getUser().getUsername().equals(username) && !p.isPrivateProfile())
            {
                return p;
            }
        }
        return null;
    }

   


    //Pretraga Profila Po Korisnickom imenu i Lozinki
    public Profile findByUserAndPass(String username, String pass) {
        List<Profile> all_profiles = this.profileRepository.findAll();

        for (Profile p : all_profiles) {
            if (Objects.equals(p.getUser().getUsername(), username) && Objects.equals(p.getUser().getPassword(), pass)) {
                return p;
            }
        }

        return null;
    }

    public List<User> findAllFollowers( Long idUser){
        Profile profile = profileRepository.findProfileById(idUser);
        List<Long> followers = profile.getFollowers();
        List<User> users = userRepository.findAll();
        List<User> findUsers = new ArrayList<>();

        for (Long f : followers) {
            for (User u : users) {
                if (u.getId().equals(f))
                    findUsers.add(u);
            }
        }
        return findUsers;

    }

}
