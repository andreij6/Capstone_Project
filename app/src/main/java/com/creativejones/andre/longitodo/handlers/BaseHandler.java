package com.creativejones.andre.longitodo.handlers;

import android.content.Context;
import android.content.Intent;

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
}
