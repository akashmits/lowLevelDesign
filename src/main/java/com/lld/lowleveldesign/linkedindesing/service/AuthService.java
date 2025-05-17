package com.lld.lowleveldesign.linkedindesing.service;

import com.lld.lowleveldesign.linkedindesing.customexception.InvalidPassword;
import com.lld.lowleveldesign.linkedindesing.dto.User;

public interface AuthService {

    public User login(String userName, String password) throws InvalidPassword;

    public void logout(String userName);


}
