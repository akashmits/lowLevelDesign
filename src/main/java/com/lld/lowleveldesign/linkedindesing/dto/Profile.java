package com.lld.lowleveldesign.linkedindesing.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class Profile {
    private long id;
    private String picture;
    private String headline;
    private String summary;
    private String experience;
    private List<Education> education;
    private List<String> skills;
    private Date createdDate;
    private Date updatedDate;
}
