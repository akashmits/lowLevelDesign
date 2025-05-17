package com.lld.lowleveldesign.taskmanagementsystem.service;


//The task management system should allow users to create, update, and delete tasks.

import com.lld.lowleveldesign.taskmanagementsystem.Status;
import com.lld.lowleveldesign.taskmanagementsystem.Task;

import java.util.List;
import java.util.Stack;

public interface TaskManagement {

    public Task createTask(Task task);
    public Task updateTask(Task task) throws Exception;
    public Task fetchTask(long taskId);
    public Task deleteTask(long taskId) throws Exception;
    public List<Task> assignedTask(long userId,Status status);
    public List<Task> assignedUserTask(long userId,long taskId);
    public List<Task> fetchAllTaskBasedOnStatus(Status status);
    public Task assignTask(Task task, long assignedTo);
    public List<Task> userAllTasks(long userId) ;


}
