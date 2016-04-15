package com.creativejones.andre.longitodo.handlers;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public abstract class BaseHandler {
    protected Context _Context;

    public BaseHandler(Context context){
        _Context = context;
    }

    protected void startActivity(Intent intent){
        _Context.startActivity(intent);
    }

    protected void startActivity(Class<?> cls){
        startActivity(new Intent(_Context, cls));
    }

    protected void Toast(String content){
        Toast.makeText(_Context, content, Toast.LENGTH_LONG).show();
    }
}
