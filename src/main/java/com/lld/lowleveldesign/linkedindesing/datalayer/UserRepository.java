package com.lld.lowleveldesign.linkedindesing.datalayer;

import com.lld.lowleveldesign.linkedindesing.customexception.UserAlreadyExists;
import com.lld.lowleveldesign.linkedindesing.dto.User;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepository {
    Map<String,User> userDetails;

    public UserRepository(){
        userDetails= new ConcurrentHashMap<>();
    }
    public void save(User user) throws UserAlreadyExists {
        if(userDetails.get(user.getName())==null){
            userDetails.put(user.getName(), user);
        }else{
            throw new UserAlreadyExists("User Already Exits"+user.getName());
        }
    }

    public User get(String userName){
        return userDetails.get(userName);
    }

    public User update(User user){
        user.setUpdatedDate(new Date());
        userDetails.put(user.getName(), user);
        return userDetails.get(user);
    }

    public boolean delete(User userName){
        User user=userDetails.get(userName);

        if(user !=null){
            user.setActive(false);
            user.setUpdatedDate(new Date());
        }
        userDetails.put(user.getName(), user);

        return  true;
    }
}
