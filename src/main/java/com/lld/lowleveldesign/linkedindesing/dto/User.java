package com.lld.lowleveldesign.linkedindesing.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@Builder
@ToString
public class User {
    private long id;
    private String name;
    private String emailId;
    private String phoneNo;
    private String password;
    private Profile profile;
    private boolean isActive;
    private Date createdDate;
    private Date updatedDate;
    private final List<Connection> connections;
    private final List<Message> inbox;
    private final List<Message> sentMessages;
}
