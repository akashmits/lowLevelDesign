package com.lld.lowleveldesign.linkedindesing.service;

import com.lld.lowleveldesign.linkedindesing.dto.Profile;
import com.lld.lowleveldesign.linkedindesing.dto.User;
import com.lld.lowleveldesign.linkedindesing.requestdto.ProfileDto;

public interface ProfileService {
    public User saveProfile(String userName, ProfileDto profileDto);

    public User update(String userName,Profile profile);
}
