package com.creativejones.andre.longitodo.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.creativejones.andre.longitodo.R;
import com.creativejones.andre.longitodo.google.GoogleServicesHelper;
import com.creativejones.andre.longitodo.handlers.ModifyTaskHandler;
import com.creativejones.andre.longitodo.viewmodels.TaskItemVM;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.ui.PlacePicker;

public class NewEditActivity extends BaseActivity
        implements ModifyTaskHandler.ModifyTaskListener, GoogleServicesHelper.GoogleServicesListener {

    public static final String EDITOR_FRAGMENT_TAG = "editor_fragment_task";
    public static final int REQUEST_PLACE_PICKER = 5588;


    TaskItemVM ViewModel;
    GoogleServicesHelper GoogleServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_edit);

        GoogleServices = new GoogleServicesHelper(this, this);

        ViewModel = TaskItemVM.newStubInstance();
        ViewModel.setContext(this);

        if(isTablet())
            addLayout(EditDualPaneFragment.newInstance(ViewModel, savedInstanceState));
        else
            addLayout(EditTaskFragment.newInstance(ViewModel));

    }

    @Override
    protected void onStart() {
        super.onStart();
        GoogleServices.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        GoogleServices.disconnect();
    }

    private void  addLayout(Fragment fragment){

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.newedit_fragment_container, fragment, EDITOR_FRAGMENT_TAG)
                .commit();

    }

    @Override
    public void onAddLocationClicked(TaskItemVM viewModel) {
        // Construct an intent for the place picker
        try {
            sendPlacesIntent();
        } catch (GooglePlayServicesRepairableException e ) {
            // ...
        } catch (GooglePlayServicesNotAvailableException e) {
            // ...
        }
    }

    @Override
    public void onSaveTask(TaskItemVM viewModel) {
        Toast.makeText(this, viewModel.getName(), Toast.LENGTH_LONG).show();
    }

    private void sendPlacesIntent() throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException{
        PlacePicker.IntentBuilder intentBuilder = new PlacePicker.IntentBuilder();
        Intent intent = intentBuilder.build(this);
        // Start the intent by requesting a result,
        // identified by a request code.
        startActivityForResult(intent, REQUEST_PLACE_PICKER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        getCurrentFragment().onActivityResult(requestCode, resultCode, data);
    }

    private Fragment getCurrentFragment(){
        return getSupportFragmentManager().findFragmentByTag(EDITOR_FRAGMENT_TAG);
    }

    @Override
    public void onConnected() {

    }

    @Override
    public void onDisconnected() {

    }
}
