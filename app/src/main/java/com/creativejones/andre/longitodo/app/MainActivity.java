package com.creativejones.andre.longitodo.app;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;

import com.creativejones.andre.longitodo.R;
import com.creativejones.andre.longitodo.databinding.ActivityMainBinding;
import com.creativejones.andre.longitodo.google.GoogleServicesHelper;
import com.creativejones.andre.longitodo.viewmodels.MainActivityVM;

public class MainActivity extends AppCompatActivity implements GoogleServicesHelper.GoogleServicesListener {

    MainActivityVM mViewModel = new MainActivityVM();
    GoogleServicesHelper mGoogleServicesHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.setVm(mViewModel.build(this, savedInstanceState));

        mGoogleServicesHelper = new GoogleServicesHelper(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mViewModel.saveInstanceState(outState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mGoogleServicesHelper.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mGoogleServicesHelper.disconnect();
    }

    //region GoogleServices.GoogleServicesListeners
    @Override
    public void onConnected() {

    }

    @Override
    public void onDisconnected() {

    }
    //endregion
}
