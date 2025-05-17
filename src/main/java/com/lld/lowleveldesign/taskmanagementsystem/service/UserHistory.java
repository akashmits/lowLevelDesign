package com.lld.lowleveldesign.taskmanagementsystem.service;

import com.lld.lowleveldesign.taskmanagementsystem.Status;
import com.lld.lowleveldesign.taskmanagementsystem.Task;

import java.util.List;

public interface UserHistory {
    public List<Task> userHistory(Long userId);
    public List<Task> userHistory(Long userId, Status status);
    public List<Task> userTask(Long userId, Long taskId);
}
