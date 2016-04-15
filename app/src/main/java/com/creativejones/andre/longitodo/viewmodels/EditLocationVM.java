package com.creativejones.andre.longitodo.viewmodels;

import com.creativejones.andre.longitodo.models.TaskLocation;

public class EditLocationVM {
    private TaskLocation Location = new TaskLocation();

    public static EditLocationVM newInstance(TaskLocation location) {
        EditLocationVM vm = new EditLocationVM();
        vm.Location = location;
        return vm;
    }

    public static EditLocationVM newInstance() {
        return new EditLocationVM();
    }
}
