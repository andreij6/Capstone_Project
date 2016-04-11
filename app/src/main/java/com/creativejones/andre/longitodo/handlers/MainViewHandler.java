package com.creativejones.andre.longitodo.handlers;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.creativejones.andre.longitodo.app.NewEditActivity;

public class MainViewHandler extends BaseHandler {

    public MainViewHandler(Context context) {
        super(context);
    }

    public void onClickNew(View view){
        startActivity(new Intent(_Context, NewEditActivity.class));
    }

    public void onClickCompleted(View view){

    }
}
