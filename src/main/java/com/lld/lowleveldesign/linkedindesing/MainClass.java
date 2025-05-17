package com.lld.lowleveldesign.linkedindesing;

import com.lld.lowleveldesign.linkedindesing.datalayer.UserRepository;
import com.lld.lowleveldesign.linkedindesing.dto.User;
import com.lld.lowleveldesign.linkedindesing.requestdto.UserDetailsDto;
import com.lld.lowleveldesign.linkedindesing.service.AuthService;
import com.lld.lowleveldesign.linkedindesing.service.RegistrationService;
import com.lld.lowleveldesign.linkedindesing.serviceimpl.AuthServiceImpl;
import com.lld.lowleveldesign.linkedindesing.serviceimpl.RegistrationServiceImpl;

public class MainClass {

    public static void main(String [] arg){
        UserRepository userRepository = new UserRepository();
        RegistrationService registrationService = new RegistrationServiceImpl(userRepository);

        AuthService authService = new AuthServiceImpl(userRepository);
        UserDetailsDto userDetailsDto = UserDetailsDto.builder().userName("akashmits").emailId("akashgoyal311@gmail.com")
                        .mobileNo("918800910515").password("Akash@123").build();
        User user=registrationService.registerUser(userDetailsDto);
        System.out.println("User Created SuccessFully "+user);

        try {
            User user1 = authService.login("akashmits", "Akash@123");
            System.out.println("User :"+user1);
        }catch(Exception ex){
            System.out.println("Exception  :"+ex.getMessage());
        }




    }
}
