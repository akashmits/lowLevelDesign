package com.lld.lowleveldesign.linkedindesing.service;

import com.lld.lowleveldesign.linkedindesing.dto.User;
import com.lld.lowleveldesign.linkedindesing.requestdto.UserDetailsDto;

public interface RegistrationService {
    public User registerUser(UserDetailsDto userDetailsDto);
}
