package com.creativejones.andre.longitodo.app;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.creativejones.andre.longitodo.R;
import com.creativejones.andre.longitodo.databinding.ActivityTaskDetailBinding;
import com.creativejones.andre.longitodo.handlers.TaskDetailHandler;
import com.creativejones.andre.longitodo.models.TaskItem;
import com.creativejones.andre.longitodo.viewmodels.TaskItemVM;

public class TaskDetailActivity extends AppCompatActivity {

    public static final String TASK_DETAIL_EXTRA = "detail_extra";

    TaskItemVM ViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTaskDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_task_detail);

        //TODO: get Item from intent
        ViewModel = new TaskItemVM(new TaskItem());

        binding.setVm(ViewModel);
        binding.setHandler(new TaskDetailHandler(this, ViewModel));

        configureToolbars();
    }

    private void configureToolbars() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Drawable upArrow = ContextCompat.getDrawable(this, R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        //upArrow.setColorFilter(ContextCompat.getColor(this, android.R.color.white), PorterDuff.Mode.SRC_ATOP);

        //getSupportActionBar().setHomeAsUpIndicator(upArrow);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(ViewModel.getName());

        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expanedappbar);
    }

}
