package com.creativejones.andre.longitodo.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.creativejones.andre.longitodo.R;
import com.creativejones.andre.longitodo.viewmodels.TaskItemVM;
import com.creativejones.andre.longitodo.widget.TasksAdapter;

public class MainActivity extends AppCompatActivity
                            implements TasksAdapter.AdapterInteractionListener
{

    private static final String MAP_LIST_FRAGMENT = "map_list_fragment_tag";
    private static final String TASK_DETAIL_FRAGMENT = "detail_tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(ShouldAttachFragment()){
            MapListFragment fragment = new MapListFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.main_fragment_container, fragment, MAP_LIST_FRAGMENT)
                    .commit();
        }
    }

    private boolean ShouldAttachFragment() {
        return getSupportFragmentManager().findFragmentByTag(MAP_LIST_FRAGMENT) == null;
    }

    @Override
    public void onShowTaskDetailInteration(TaskItemVM viewModel) {
        TaskItemDetailFragment fragment = TaskItemDetailFragment.newInstance(viewModel);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container, fragment, TASK_DETAIL_FRAGMENT)
                .addToBackStack(null)
                .commit();
    }
}
