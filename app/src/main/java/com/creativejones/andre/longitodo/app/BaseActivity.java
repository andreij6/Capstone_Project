package com.creativejones.andre.longitodo.app;

import android.support.v7.app.AppCompatActivity;

import com.creativejones.andre.longitodo.R;

public abstract class BaseActivity extends AppCompatActivity {

    protected boolean isTablet() {
        return getResources().getBoolean(R.bool.is_tablet);
    }
}
