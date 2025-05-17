package com.lld.lowleveldesign.taskmanagementsystem;

import com.lld.lowleveldesign.taskmanagementsystem.service.TaskManagement;
import com.lld.lowleveldesign.taskmanagementsystem.service.impl.TaskManagementImpl;

import java.util.Date;

public class TaskManagementMain {
    public static void main(String [] arg){
        User user1 = new User("Akash01",1001);
        User user2 = new User("Raman01",1002);

        Task task1 = Task.builder().createdDate(new Date()).description("Test1").priority(Priority.LOW).status(Status.TODO).title("Test1").userId(user1.getId()).build();
        Task task2 = Task.builder().createdDate(new Date()).description("Test1").priority(Priority.LOW).status(Status.TODO).title("Test1").userId(user1.getId()).build();


        TaskManagement taskManagement= new TaskManagementImpl();

        taskManagement.createTask(task1);
        taskManagement.createTask(task2);

        System.out.println(taskManagement.fetchAllTaskBasedOnStatus(Status.TODO));

        taskManagement.assignTask(taskManagement.fetchTask(1),1002);
        taskManagement.assignTask(taskManagement.fetchTask(2),1002);

        System.out.println(taskManagement.fetchAllTaskBasedOnStatus(Status.INPROGRESS));


        taskManagement.assignTask(taskManagement.fetchTask(1),1002);


    }
}
