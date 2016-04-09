package com.creativejones.andre.longitodo.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.creativejones.andre.longitodo.R;
import com.creativejones.andre.longitodo.viewmodels.TaskItemVM;

public class NewEditActivity extends AppCompatActivity {

    public static final String EDIT_MODEL_KEY = "edit_key";

    TaskItemVM ViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_edit);

        ViewModel = TaskItemVM.newStubInstance();

        if(isTablet())
            addDualPaneLayout();
        else
            singlePaneLayout();

    }

    private void singlePaneLayout() {

    }

    private void addDualPaneLayout() {

    }

    public boolean isTablet() {
        return getResources().getBoolean(R.bool.is_tablet);
    }
}
