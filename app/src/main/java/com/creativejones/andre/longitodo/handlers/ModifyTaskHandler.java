package com.creativejones.andre.longitodo.handlers;

import android.content.Context;
import android.view.View;

import com.creativejones.andre.longitodo.viewmodels.TaskItemVM;

public class ModifyTaskHandler extends BaseHandler {

    TaskItemVM ViewModel;

    public ModifyTaskHandler(Context context, TaskItemVM viewModel) {
        super(context);
        ViewModel = viewModel;
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
}
