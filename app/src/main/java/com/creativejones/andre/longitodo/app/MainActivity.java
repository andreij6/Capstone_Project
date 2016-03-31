package com.creativejones.andre.longitodo.app;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.creativejones.andre.longitodo.R;
import com.creativejones.andre.longitodo.databinding.ActivityMainBinding;
import com.creativejones.andre.longitodo.viewmodels.MainActivityVM;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setVm(new MainActivityVM());
    }


}
