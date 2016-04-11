package com.creativejones.andre.longitodo.app;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.creativejones.andre.longitodo.R;
import com.creativejones.andre.longitodo.databinding.FragmentMapListBinding;
import com.creativejones.andre.longitodo.google.GoogleServicesHelper;
import com.creativejones.andre.longitodo.handlers.MainViewHandler;
import com.creativejones.andre.longitodo.models.TaskItem;
import com.creativejones.andre.longitodo.viewmodels.MapListViewModel;
import com.creativejones.andre.longitodo.widget.TasksAdapter;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class MapListFragment extends Fragment
        implements GoogleServicesHelper.GoogleServicesListener {

    private static final String MAP_FRAGMENT_TAG = "map_fragment_tag";

    MapListViewModel ViewModel;
    FragmentMapListBinding Binding;
    GoogleServicesHelper GoogleHelper;
    SupportMapFragment mMapFragment;

    public MapListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewModel = MapListViewModel.newInstance(getActivity(), savedInstanceState);

        GoogleHelper = new GoogleServicesHelper(this, getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Binding = DataBindingUtil.inflate(inflater, R.layout.fragment_map_list, container, false);

        initializeMap();

        Binding.setViewmodel(ViewModel);
        Binding.setHandler(new MainViewHandler(getActivity()));

        return Binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        createRecycler();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ViewModel.saveInstanceState(outState);
    }

    @Override
    public void onStart() {
        super.onStart();
        GoogleHelper.connect();
    }

    @Override
    public void onStop() {
        super.onStop();
        GoogleHelper.disconnect();
    }

    //region Google Play Services Listener
    @Override
    public void onConnected() {

    }

    @Override
    public void onDisconnected() {

    }
    //endregion Google Play Services Listener

    private void initializeMap() {
        mMapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentByTag(MAP_FRAGMENT_TAG);

        if(mMapFragment == null){

            mMapFragment= SupportMapFragment.newInstance();

            getChildFragmentManager()
                    .beginTransaction()
                    .add(R.id.map_container, mMapFragment, MAP_FRAGMENT_TAG)
                    .commit();
        }

        mMapFragment.getMapAsync(ViewModel.getMapHelper());

    }

    private void createRecycler() {
        List<TaskItem> fakeData = new ArrayList<>();

        TaskItem bob = new TaskItem();
        bob.setName("Bob");
        fakeData.add(bob);

        Binding.taskList.setAdapter(new TasksAdapter(getActivity(), fakeData));
        Binding.taskList.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

}
