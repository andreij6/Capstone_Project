package com.creativejones.andre.longitodo.models;

import android.content.Context;

import com.creativejones.andre.longitodo.viewmodels.TaskItemVM;

public class TaskItem {

    private String Name, Category, Description;
    private boolean isCompleted;
    private int _Priority;
    private TaskLocation Location;

    public TaskItem(){
        Name = "bob";
        isCompleted = false;
        _Priority = TaskPriority.MEDIUM;
        Category = "Shoe Shopping";
    }

    public TaskItemVM toViewModel(Context context) {
        TaskItemVM viewModel = TaskItemVM.newInstance(this);
        viewModel.setItem(this);
        viewModel.setContext(context);
        return viewModel;
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

    public void complete(boolean isComplete) {
        isCompleted = isComplete;
    }

    public String getCategory() {
        return Category;
    }

    public void setDescription(String desc){
        Description = desc;
    }

    public String getDescription() {
        return Description;
    }

    public boolean hasLocation() {
        return Location != null;
    }

    public TaskLocation getLocation() {
        return Location;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setLocation(TaskLocation location) {
        Location = location;
    }

    public void setPriority(int priority) {
        _Priority = priority;
    }

    //endregion

    public static class TaskPriority {
        public static final int HIGH = 1000;
        public static final int MEDIUM = 500;
        public static final int LOW = 0;
    }
}
