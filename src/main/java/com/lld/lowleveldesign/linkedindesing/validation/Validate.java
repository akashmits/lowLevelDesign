package com.lld.lowleveldesign.linkedindesing.validation;

import com.lld.lowleveldesign.linkedindesing.customexception.InvalidateInput;
import com.lld.lowleveldesign.linkedindesing.requestdto.UserDetailsDto;

public class Validate {
    public void validate(UserDetailsDto userDetailsDto) throws InvalidateInput {
        if(userDetailsDto.getUserName()==null || userDetailsDto.getEmailId()==null || userDetailsDto.getPassword()==null || userDetailsDto.getMobileNo()==null){
            throw new InvalidateInput("Wrong Input");
        }
    }
}
