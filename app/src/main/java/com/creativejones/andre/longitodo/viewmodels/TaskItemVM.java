package com.creativejones.andre.longitodo.viewmodels;

import android.content.Context;

import com.creativejones.andre.longitodo.R;
import com.creativejones.andre.longitodo.models.TaskItem;

public class TaskItemVM {

    public static final String KEY = "vm_key";
    
    private TaskItem item;
    private Context _Context;

    public static TaskItemVM newInstance(TaskItem taskItem) {
        return new TaskItemVM(taskItem);
    }

    public static TaskItemVM newStubInstance() {
        TaskItem item = new TaskItem();
        item.setName("Bob");
        item.setDescription("This is a good long description");
        return new TaskItemVM(item);
    }

    public TaskItemVM(TaskItem _item){
        item = _item;
    }

    public boolean hasLocation() {
        return true;
    }

    public boolean isCompleted() {
        return item.isCompleted();
    }

    public String getName() {
        return item.getName();
    }

    public int getPriorityColor() {
        switch (item.getPriority()){
            case TaskItem.TaskPriority.HIGH:
                return R.color.accent;
            case TaskItem.TaskPriority.MEDIUM:
                return R.color.primary;
            case TaskItem.TaskPriority.LOW:
                return R.color.primaryLight;
            default:
                return android.R.color.transparent;
        }
    }

    public void markAsComplete() {
        item.complete(!item.isCompleted());
    }

    public String getCategory() {
        return item.getCategory();
    }

    public String getPriorityName(){

        switch (item.getPriority()){
            case TaskItem.TaskPriority.HIGH:
                return getString(R.string.priorityHigh);
            case TaskItem.TaskPriority.MEDIUM:
                return getString(R.string.priorityMedium);
            case TaskItem.TaskPriority.LOW:
                return getString(R.string.priorityLow);
            default:
                return getString(R.string.priorityNone);
        }
    }

    public String getDescription(){
        return item.getDescription();
    }

    public String getLocationName(){
        return item.hasLocation() ? item.getLocation().getName() : getString(R.string.no_location);
    }

    private String getString(int resourceId) {
        return _Context.getString(resourceId);
    }

    public void set_Context(Context context) {
        _Context = context;
    }
}
