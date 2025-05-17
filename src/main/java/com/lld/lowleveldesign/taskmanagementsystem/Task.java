package com.lld.lowleveldesign.taskmanagementsystem;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Builder
@ToString
public class Task {
    private Long taskId;
    private String title;
    private String description;
    private Date createdDate;
    private Date dueDate;
    private Priority priority=Priority.LOW;
    private Status status=Status.TODO;
    private Long userId;
    private Long assignUserId;
}
