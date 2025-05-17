package com.lld.lowleveldesign.linkedindesing.requestdto;

import lombok.Data;

import java.util.List;

@Data
public class ProfileDto {
    private String picture;
    private String headline;
    private String summary;
    private String experience;
    private String education;
    private List<String> skills;
}
