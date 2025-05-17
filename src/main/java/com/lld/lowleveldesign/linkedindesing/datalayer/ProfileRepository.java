package com.lld.lowleveldesign.linkedindesing.datalayer;

import com.lld.lowleveldesign.linkedindesing.dto.Profile;
import com.lld.lowleveldesign.linkedindesing.dto.User;

import java.util.Date;

public class ProfileRepository {
    UserRepository userRepository;
    public ProfileRepository(UserRepository userRepository){
        this.userRepository=userRepository;
    }


    public  User saveProfile(String userName, Profile profile){
        User user =userRepository.get(userName);
        user.setProfile(profile);
        userRepository.update(user);

        return user;
    }


    public User update(String userName,Profile profile){
        User user =userRepository.get(userName);
        user.getProfile().setUpdatedDate(new Date());
        user.setProfile(profile);
        userRepository.update(user);

        return user;
    }



}
