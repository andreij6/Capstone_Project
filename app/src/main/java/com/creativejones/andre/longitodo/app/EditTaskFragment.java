package com.creativejones.andre.longitodo.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creativejones.andre.longitodo.R;

public class EditTaskFragment extends BaseEditorFragment {

    public static final String FRAGMENT_TAG = "editor_tag";

    public static EditTaskFragment newInstance(){
        return new EditTaskFragment();
    }

    public static EditTaskFragment newInstance(Bundle savedInstanceState) {
        return new EditTaskFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit_task, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public String getEditorTag() {
        return FRAGMENT_TAG;
    }
}

