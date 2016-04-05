package com.creativejones.andre.longitodo.viewmodels;

import com.creativejones.andre.longitodo.R;
import com.creativejones.andre.longitodo.models.TaskItem;

public class TaskItemVM {
    
    private TaskItem item;

    public static TaskItemVM newInstance(TaskItem taskItem) {
        return new TaskItemVM(taskItem);
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

    public int getPriority() {
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
        item.complete();
    }

    public String getCategory() {
        return item.getCategory();
    }
}
