package com.lld.lowleveldesign.taskmanagementsystem.service;

import com.lld.lowleveldesign.taskmanagementsystem.User;

// Users should be able to assign tasks to other users and set reminders for tasks.

public interface UserManagement {

    public void createUser(User user);
    public User getUser(long userId);
    public void updateUset(User user);
    public void deleteUser(long userId);

}
