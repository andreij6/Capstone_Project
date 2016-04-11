package com.creativejones.andre.longitodo.handlers;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.creativejones.andre.longitodo.app.MainActivity;
import com.creativejones.andre.longitodo.app.NewEditActivity;
import com.creativejones.andre.longitodo.viewmodels.TaskItemVM;

public class TaskDetailHandler extends BaseHandler {

    private TaskItemVM ViewModel;

    public TaskDetailHandler(Context context, TaskItemVM viewModel) {
        super(context);
        ViewModel = viewModel;
    }

    @SuppressWarnings("unused")
    public void onClickMap(View view){
        startActivity(new Intent(_Context, MainActivity.class));
    }

    @SuppressWarnings("unused")
    public void onClickEdit(View view){
        startActivity(new Intent(_Context, NewEditActivity.class));
        //.putExtra(NewEditActivity.EDIT_MODEL_KEY, ViewModel)
    }
}
