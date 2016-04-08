package com.creativejones.andre.longitodo.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.creativejones.andre.longitodo.R;

public class NewEditActivity extends AppCompatActivity {

    public static final String EDIT_MODEL_KEY = "edit_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_edit);


    }
}
