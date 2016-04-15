package com.creativejones.andre.longitodo.handlers;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.creativejones.andre.longitodo.databinding.FragmentEditTaskBinding;
import com.creativejones.andre.longitodo.viewmodels.TaskItemVM;

public class ModifyTaskHandler extends BaseHandler {

    TaskItemVM ViewModel;
    ModifyTaskListener Listener;
    FragmentEditTaskBinding Binding;

    public ModifyTaskHandler(Context context, TaskItemVM viewModel, FragmentEditTaskBinding binding) {
        super(context);
        ViewModel = viewModel;
        Listener = (ModifyTaskListener)context;
        Binding = binding;
    }

    public void markAsComplete(View view){
        ViewModel.markAsComplete();
    }

    public void remove(View view){
        //Dialog are you sure.

        //if yes
            //Dialog should complete removal
            //Navigate to map
        //if no
            //dimiss dialog
    }

    public void onClickAddLocation(View view){
        Listener.onAddLocationClicked(ViewModel);
    }

    public void onClickSaveTask(View view){
        makeChanges();
        Listener.onSaveTask(ViewModel);
    }

    public void makeChanges() {
        ViewModel.setName(Binding.editTaskName.getText().toString());
    }

    public interface ModifyTaskListener {
        void onAddLocationClicked(TaskItemVM model);

        void onSaveTask(TaskItemVM model);
    }
}
