package com.creativejones.andre.longitodo.app;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creativejones.andre.longitodo.R;
import com.creativejones.andre.longitodo.databinding.FragmentTaskItemDetailBinding;
import com.creativejones.andre.longitodo.handlers.TaskDetailHandler;
import com.creativejones.andre.longitodo.viewmodels.TaskItemVM;

public class TaskItemDetailFragment extends Fragment {

    TaskItemVM ViewModel;
    FragmentTaskItemDetailBinding Binding;

    public static TaskItemDetailFragment newInstance(TaskItemVM vm){
        return new TaskItemDetailFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //ViewModel = getArguments().get(TaskItemVM.KEY);
        ViewModel = TaskItemVM.newStubInstance();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Binding = DataBindingUtil.inflate(inflater, R.layout.fragment_task_item_detail, container, false);

        Binding.setModel(ViewModel);
        Binding.setHandler(new TaskDetailHandler(getActivity(), ViewModel));

        return Binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    /*
    private void configureToolbars() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Drawable upArrow = ContextCompat.getDrawable(this, R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        upArrow.setColorFilter(ContextCompat.getColor(this, android.R.color.white), PorterDuff.Mode.SRC_ATOP);

        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(ViewModel.getName());

        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expanedappbar);
    }
    */
}
