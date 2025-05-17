package com.lld.lowleveldesign.taskmanagementsystem.service;

import com.lld.lowleveldesign.taskmanagementsystem.Priority;
import com.lld.lowleveldesign.taskmanagementsystem.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class FilterModel {
    public Priority priority;
    public Date dueDate;
    public User userId;

}
