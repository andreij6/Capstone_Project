package com.creativejones.andre.longitodo.models;

import com.creativejones.andre.longitodo.viewmodels.TaskItemVM;

public class TaskItem {

    private String Name, Category;
    private boolean isCompleted;
    private int _Priority;

    public TaskItem(){
        Name = "bob";
        isCompleted = false;
        _Priority = TaskPriority.MEDIUM;
        Category = "Shoe Shopping";
    }

    public TaskItemVM toViewModel() {
        return TaskItemVM.newInstance(this);
    }

    //region Getters & Setters
    public String getName(){
        return Name;
    }

    public void setName(String name){
        Name = name;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public int getPriority() {
        return _Priority;
    }

    public void complete() {
        isCompleted = true;
    }

    public String getCategory() {
        return Category;
    }
    //endregion

    public static class TaskPriority {
        public static final int HIGH = 1000;
        public static final int MEDIUM = 500;
        public static final int LOW = 0;
    }
}
