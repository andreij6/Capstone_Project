package com.creativejones.andre.longitodo.app;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.creativejones.andre.longitodo.R;
import com.creativejones.andre.longitodo.databinding.FragmentEditTaskBinding;
import com.creativejones.andre.longitodo.handlers.ModifyTaskHandler;
import com.creativejones.andre.longitodo.viewmodels.TaskItemVM;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.model.LatLng;

public class EditTaskFragment extends Fragment implements EditLocationDialogFragment.EditLocationInteraction {

    private TaskItemVM ViewModel;
    FragmentEditTaskBinding Binding;
    private LatLng Position;
    private String Name;

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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == NewEditActivity.REQUEST_PLACE_PICKER && resultCode == NewEditActivity.RESULT_OK) {

            // The user has selected a place. Extract the name and address.
            final Place place = PlacePicker.getPlace(data, getActivity());

            Position = place.getLatLng();
            Name = place.getName().toString();

            EditLocationDialogFragment dialog = EditLocationDialogFragment.newInstance(this, Name);

            dialog.show(getChildFragmentManager(), "location");

        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
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

    public void setViewModel(TaskItemVM viewModel) {
        ViewModel = viewModel;
    }

    @Override
    public void onPositiveClick(String name) {
        Name = name;
    }

    @Override
    public void onNegativeClick() {

    }
}

