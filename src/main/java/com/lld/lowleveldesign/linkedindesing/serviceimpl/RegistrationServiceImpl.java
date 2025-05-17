package com.lld.lowleveldesign.linkedindesing.serviceimpl;

import com.lld.lowleveldesign.linkedindesing.customexception.InvalidateInput;
import com.lld.lowleveldesign.linkedindesing.customexception.UserAlreadyExists;
import com.lld.lowleveldesign.linkedindesing.datalayer.UserRepository;
import com.lld.lowleveldesign.linkedindesing.dto.User;
import com.lld.lowleveldesign.linkedindesing.service.RegistrationService;
import com.lld.lowleveldesign.linkedindesing.requestdto.UserDetailsDto;
import com.lld.lowleveldesign.linkedindesing.validation.Validate;

import java.util.Date;

public class RegistrationServiceImpl implements RegistrationService {
    private UserRepository userRepository;
    private Validate validate;
    public RegistrationServiceImpl(UserRepository userRepository){

        this.userRepository=userRepository;
        this.validate = new Validate();

    }
    @Override
    public User registerUser(UserDetailsDto userDetailsDto) {
        try {
            validate.validate(userDetailsDto);
            User user = User.builder().emailId(userDetailsDto.getEmailId()).createdDate(new Date()).password(userDetailsDto.getPassword())
                            .isActive(true).name(userDetailsDto.getUserName()).phoneNo(userDetailsDto.getMobileNo()).updatedDate(new Date())
                            .build();
            userRepository.save(user);
            return user;
        } catch(InvalidateInput ex){
            System.out.println("INput not valid :"+ex.getMessage()+"User Object "+userDetailsDto);
        }catch(UserAlreadyExists userAlreadyExists){
            System.out.println("User Already Exits :"+userAlreadyExists.getMessage()+"User Object "+userDetailsDto);
        }
        return null;
    }
}
