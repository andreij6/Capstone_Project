package com.creativejones.andre.longitodo.app;

import android.os.Bundle;
import android.widget.Toast;

import com.creativejones.andre.longitodo.R;
import com.creativejones.andre.longitodo.handlers.ModifyTaskHandler;
import com.creativejones.andre.longitodo.viewmodels.TaskItemVM;

public class NewEditActivity extends BaseActivity implements ModifyTaskHandler.ModifyTaskListener {

    public static final String EDIT_MODEL_KEY = "edit_key";
    private static final String EDIT_TASK_TAG = "edit_task_tag";


    TaskItemVM ViewModel;
    boolean fragmentPresent = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_edit);

        ViewModel = TaskItemVM.newStubInstance();
        ViewModel.setContext(this);

        if(isTablet())
            addLayout(EditDualPaneFragment.newInstance(ViewModel, savedInstanceState));
        else
            addLayout(savedInstanceState == null ? EditTaskFragment.newInstance(ViewModel) : existingFragment());

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

        return EditTaskFragment.newInstance(ViewModel);

    }

    private <T extends BaseEditorFragment> void  addLayout(T fragment){
        if(!fragmentPresent) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.newedit_fragment_container, fragment, fragment.getEditorTag())
                    .commit();
        }
    }

    @Override
    public void onAddLocationClicked(TaskItemVM viewModel) {
        MapTaskFragment fragment = MapTaskFragment.newInstance(viewModel);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.newedit_fragment_container, fragment, fragment.getEditorTag())
                .addToBackStack(null)
                .commit();
    }
}
