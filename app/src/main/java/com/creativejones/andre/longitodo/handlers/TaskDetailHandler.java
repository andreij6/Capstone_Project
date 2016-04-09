package com.creativejones.andre.longitodo.handlers;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.creativejones.andre.longitodo.app.MainActivity;
import com.creativejones.andre.longitodo.app.NewEditActivity;
import com.creativejones.andre.longitodo.viewmodels.TaskItemVM;

public class TaskDetailHandler {

    private TaskItemVM ViewModel;
    private Context _Context;

    public TaskDetailHandler(Context context, TaskItemVM viewModel) {
        ViewModel = viewModel;
        _Context = context;
    }

    @SuppressWarnings("unused")
    public void onClickMap(View view){
        _Context.startActivity(new Intent(_Context, MainActivity.class));
    }

    @SuppressWarnings("unused")
    public void onClickEdit(View view){
        _Context.startActivity(new Intent(_Context, NewEditActivity.class));
        //.putExtra(NewEditActivity.EDIT_MODEL_KEY, ViewModel)
    }
}
