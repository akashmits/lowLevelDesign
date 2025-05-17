package com.lld.lowleveldesign.linkedindesing.serviceimpl;

import com.lld.lowleveldesign.linkedindesing.customexception.InvalidPassword;
import com.lld.lowleveldesign.linkedindesing.datalayer.UserRepository;
import com.lld.lowleveldesign.linkedindesing.dto.User;
import com.lld.lowleveldesign.linkedindesing.service.AuthService;

public class AuthServiceImpl implements AuthService {
    private UserRepository userRepository;
    public AuthServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public User login(String userName, String password) throws InvalidPassword {
        User user=userRepository.get(userName);

        if(user ==null || user.getPassword()!=password)
                throw new InvalidPassword("Invalid Password");
        return user;
    }

    @Override
    public void logout(String userName) {

    }
}
