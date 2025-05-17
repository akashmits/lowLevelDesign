package com.lld.lowleveldesign.taskmanagementsystem.service;

import com.lld.lowleveldesign.taskmanagementsystem.Task;

import java.util.List;

public interface FilterService {
    public List<Task> search(FilterModel filter);
}
