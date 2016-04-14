package com.creativejones.andre.longitodo.app;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.creativejones.andre.longitodo.R;
import com.creativejones.andre.longitodo.databinding.FragmentEditTaskBinding;
import com.creativejones.andre.longitodo.databinding.FragmentMapListBinding;
import com.creativejones.andre.longitodo.handlers.ModifyTaskHandler;
import com.creativejones.andre.longitodo.viewmodels.TaskItemVM;

public class EditTaskFragment extends BaseEditorFragment {

    public static final String FRAGMENT_TAG = "editor_tag";

    private TaskItemVM ViewModel;
    FragmentEditTaskBinding Binding;

    public static EditTaskFragment newInstance(TaskItemVM vm){
        EditTaskFragment fragment = new EditTaskFragment();
        fragment.setViewModel(vm);
        return fragment;
    }

    public static EditTaskFragment newInstance(Bundle savedInstanceState) {
        return new EditTaskFragment();
    }

    public EditTaskFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //ViewModel = TaskItemVM.newStubInstance();
        ViewModel = TaskItemVM.newEmptyInstance(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Binding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_task, container, false);

        Binding.setViewmodel(ViewModel);
        Binding.setHandler(new ModifyTaskHandler(getActivity(), ViewModel));

        return Binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setSpinnerItems(Binding.editTaskCategory, getCategories());
        setSpinnerItems(Binding.editTaskPrioritySpinner, getPriorities());
    }

    private void setSpinnerItems(Spinner spinner, final String[] items) {
        spinner.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, items));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "Item Tapped: " + items[position], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private String[] getPriorities(){
        return getResources().getStringArray(R.array.priorityOptions);
    }

    private String[] getCategories(){
        return new String[]{ "Shopping", "Grocery", "Errands"};
    }

    @Override
    public String getEditorTag() {
        return FRAGMENT_TAG;
    }

    public void setViewModel(TaskItemVM viewModel) {
        ViewModel = viewModel;
    }
}

