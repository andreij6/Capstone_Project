package com.creativejones.andre.longitodo.app;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.creativejones.andre.longitodo.R;
import com.creativejones.andre.longitodo.databinding.ActivityMainBinding;
import com.creativejones.andre.longitodo.google.GoogleServicesHelper;
import com.creativejones.andre.longitodo.models.TaskItem;
import com.creativejones.andre.longitodo.viewmodels.MainActivityVM;
import com.creativejones.andre.longitodo.widget.TasksAdapter;
import com.google.android.gms.maps.SupportMapFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements GoogleServicesHelper.GoogleServicesListener {

    MainActivityVM ViewModel;
    GoogleServicesHelper GoogleServicesHelper;
    ActivityMainBinding Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        ViewModel = MainActivityVM.newInstance(this, savedInstanceState);

        Binding.setVm(ViewModel);

        initMap();

        createRecycler();

        GoogleServicesHelper = new GoogleServicesHelper(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ViewModel.saveInstanceState(outState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        GoogleServicesHelper.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        GoogleServicesHelper.disconnect();
    }

    //region Helpers
    private void initMap() {
        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager()
                                                                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(ViewModel.getMapHelper());
    }

    private void createRecycler() {
        List<TaskItem> fakeData = new ArrayList<>();

        TaskItem bob = new TaskItem();
        bob.setName("Bob");
        fakeData.add(bob);

        Binding.taskList.setAdapter(new TasksAdapter(this, fakeData));
        Binding.taskList.setLayoutManager(new LinearLayoutManager(this));
    }
    //endregion

    //region GoogleServices.GoogleServicesListeners
    @Override
    public void onConnected() {

    }

    @Override
    public void onDisconnected() {

    }
    //endregion

}
