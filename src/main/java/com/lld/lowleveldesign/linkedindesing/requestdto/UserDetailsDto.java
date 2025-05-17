package com.lld.lowleveldesign.linkedindesing.requestdto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class UserDetailsDto {
    private String userName;
    private String emailId;
    private String mobileNo;
    private String password;
}
