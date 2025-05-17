package com.lld.lowleveldesign.taskmanagementsystem.service.impl;

import com.lld.lowleveldesign.taskmanagementsystem.Status;
import com.lld.lowleveldesign.taskmanagementsystem.Task;
import com.lld.lowleveldesign.taskmanagementsystem.service.TaskManagement;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class TaskManagementImpl implements TaskManagement {

    Map<Long,Task> taskMapping;
    volatile long autoIncrementId;

    public TaskManagementImpl() {
        synchronized (this) {
            if (taskMapping == null) {
                this.taskMapping = new ConcurrentHashMap<>();
                this.autoIncrementId = 0;

            }
        }
    }
    @Override
    public Task createTask(Task task) {
        if(task.getTaskId()==null){
            ++autoIncrementId;
            task.setTaskId(autoIncrementId);
        }
        taskMapping.put(task.getTaskId(),task);
        return task;
    }

    @Override
    public Task updateTask(Task task) throws Exception {
        Task newTask=taskMapping.get(task.getTaskId());

        if(newTask==null) {
            System.out.println("Update : Invalid Task Id");
            throw new Exception("UpdateFlow : Invalid Task info");
        }

        taskMapping.put(task.getTaskId(), task);
        return task;
    }

    @Override
    public Task fetchTask(long taskId) {
        return taskMapping.get(taskId);
    }

    @Override
    public Task deleteTask(long taskId) throws Exception {
        Task newTask=taskMapping.get(taskId);
        if(newTask==null){
            System.out.println("DeleteFlow : Invalid Task Id"+taskId);
            throw new Exception("DeleteFLow : Invalid Task info:"+taskId);
        }
        return newTask;
    }

    @Override
    public List<Task> assignedTask(long userId, Status status) {

        List<Task> tasklist= taskMapping.entrySet().stream()
                .filter(entry -> entry.getValue().getStatus().equals(status)) // Filter by status
                .filter(entry -> entry.getValue().getUserId().equals(userId)) // Filter by user (add your condition)
                .map(Map.Entry::getValue) // Extract Task objects
                .collect(Collectors.toList());
        return tasklist;
    }

    @Override
    public List<Task> assignedUserTask(long userId, long taskId) {
        List<Task> tasklist= taskMapping.entrySet().stream()
                .filter(entry -> entry.getValue().getTaskId().equals(taskId)) // Filter by status
                .filter(entry -> entry.getValue().getUserId().equals(userId)) // Filter by user (add your condition)
                .map(Map.Entry::getValue) // Extract Task objects
                .collect(Collectors.toList());
        return null;
    }

    @Override
    public List<Task> userAllTasks(long userId) {

        List<Task> tasklist= taskMapping.entrySet().stream()
                .filter(entry -> entry.getValue().getUserId().equals(userId)) // Filter by user (add your condition)
                .map(Map.Entry::getValue) // Extract Task objects
                .collect(Collectors.toList());
        return tasklist;
    }

    @Override
    public List<Task> fetchAllTaskBasedOnStatus(Status status) {
        System.out.println("TaskMapping:"+taskMapping);
        List<Task> tasklist= taskMapping.entrySet().stream()
                .filter(entry -> entry.getValue().getStatus().equals(status)) // Filter by status
                .map(Map.Entry::getValue) // Extract Task objects
                .collect(Collectors.toList());
        return tasklist;
    }

    @Override
    public Task assignTask(Task task, long assignedTo) {
        Task newTask=taskMapping.get(task.getTaskId());

        if(newTask != null){
            newTask.setAssignUserId(assignedTo);
            newTask.setStatus(Status.INPROGRESS);
            taskMapping.put(task.getTaskId(), newTask);
        }
        return newTask;
    }

    //mark task completed
    public void completeTask(Long taskId, long assignedTo) {

        Task newTask=taskMapping.get(taskId);
        newTask.setStatus(Status.COMPLETED);
        taskMapping.put(newTask.getTaskId(), newTask);

    }

}
