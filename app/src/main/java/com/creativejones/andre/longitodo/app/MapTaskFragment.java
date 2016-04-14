package com.creativejones.andre.longitodo.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creativejones.andre.longitodo.R;
import com.creativejones.andre.longitodo.viewmodels.TaskItemVM;

public class MapTaskFragment extends BaseEditorFragment {

    public static final String FRAGMENT_TAG = "map_task_fragment";
    private TaskItemVM ViewModel;
    
    public static MapTaskFragment newInstance(TaskItemVM viewModel) {
        MapTaskFragment fragment = new MapTaskFragment();
        fragment.setViewModel(viewModel);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map_task, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public String getEditorTag() {
        return FRAGMENT_TAG;
    }

    public void setViewModel(TaskItemVM viewModel) {
        ViewModel = viewModel;
    }
}
