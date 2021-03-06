package com.creativejones.andre.longitodo.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creativejones.andre.longitodo.R;
import com.creativejones.andre.longitodo.viewmodels.TaskItemVM;

public class EditDualPaneFragment extends Fragment {

    public static final String FRAGMENT_TAG = "dual_editor_tag";

    public static EditDualPaneFragment newInstance(TaskItemVM viewModel, Bundle savedInstanceState) {
        return new EditDualPaneFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit_dual_pane, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
