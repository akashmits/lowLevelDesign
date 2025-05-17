package com.lld.lowleveldesign.taskmanagementsystem.service.impl;

import com.lld.lowleveldesign.taskmanagementsystem.Status;
import com.lld.lowleveldesign.taskmanagementsystem.Task;
import com.lld.lowleveldesign.taskmanagementsystem.service.TaskManagement;
import com.lld.lowleveldesign.taskmanagementsystem.service.UserHistory;

import java.util.List;

public class UserHistoryImpl implements UserHistory {
    public UserHistory userHistory;
    public TaskManagement taskManagement;
public UserHistoryImpl(){
    synchronized (this){
        if(userHistory == null) {
            this.taskManagement=new TaskManagementImpl();
        }
    }
}

    @Override
    public List<Task> userHistory(Long userId) {
        return taskManagement.userAllTasks(userId);
    }

    @Override
    public List<Task> userHistory(Long userId, Status status) {
      return taskManagement.assignedTask(userId,status);
    }

    @Override
    public List<Task> userTask(Long userId, Long taskId) {
        return taskManagement.assignedUserTask(userId,taskId);
    }
}
