package com.creativejones.andre.longitodo.app;

import android.os.Bundle;

import com.creativejones.andre.longitodo.R;
import com.creativejones.andre.longitodo.viewmodels.TaskItemVM;

public class NewEditActivity extends BaseActivity {

    public static final String EDIT_MODEL_KEY = "edit_key";
    private static final String EDIT_TASK_TAG = "edit_task_tag";


    TaskItemVM ViewModel;
    boolean fragmentPresent = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_edit);

        ViewModel = TaskItemVM.newStubInstance();

        if(isTablet())
            addLayout(EditDualPaneFragment.newInstance(savedInstanceState));
        else {
            addLayout(savedInstanceState == null ? EditTaskFragment.newInstance() : existingFragment());
        }

    }

    private BaseEditorFragment existingFragment() {

        EditTaskFragment fragment = (EditTaskFragment)getSupportFragmentManager().findFragmentByTag(EditTaskFragment.FRAGMENT_TAG);

        if(fragment != null) {
            fragmentPresent = true;
            return fragment;
        }


        MapTaskFragment mapFragment = (MapTaskFragment)getSupportFragmentManager().findFragmentByTag(MapTaskFragment.FRAGMENT_TAG);

        if(mapFragment != null) {
            fragmentPresent = true;
            return mapFragment;
        }

        return EditTaskFragment.newInstance();

    }

    private <T extends BaseEditorFragment> void  addLayout(T fragment){
        if(!fragmentPresent) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.newedit_fragment_container, fragment, fragment.getEditorTag())
                    .commit();
        }
    }
}
