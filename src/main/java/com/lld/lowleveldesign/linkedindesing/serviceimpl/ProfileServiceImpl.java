package com.lld.lowleveldesign.linkedindesing.serviceimpl;

import com.lld.lowleveldesign.linkedindesing.datalayer.ProfileRepository;
import com.lld.lowleveldesign.linkedindesing.dto.Profile;
import com.lld.lowleveldesign.linkedindesing.dto.User;
import com.lld.lowleveldesign.linkedindesing.requestdto.ProfileDto;
import com.lld.lowleveldesign.linkedindesing.service.ProfileService;

import java.util.Date;

public class ProfileServiceImpl implements ProfileService {
    private ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository){
        this.profileRepository=profileRepository;
    }

    @Override
    public User saveProfile(String userName, ProfileDto profileDto) {
        Profile profile = Profile.builder().education(null).experience(profileDto.getExperience()).headline(profileDto.getHeadline()).picture(profileDto.getPicture())
                .skills(profileDto.getSkills()).summary(profileDto.getSummary()).createdDate(new Date())
                .updatedDate(new Date()).build();
       return profileRepository.saveProfile(userName,profile);
    }

    @Override
    public User update(String userName, Profile profile) {
        return profileRepository.saveProfile(userName,profile);
    }
}
