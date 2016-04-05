package com.creativejones.andre.longitodo.app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.creativejones.andre.longitodo.R;
import com.creativejones.andre.longitodo.models.TaskItem;

import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.BaseHolder> {

    private static final int DAY_OF_WEEK_VIEW = 333;
    private static final int TASK_ITEM_VIEW = 444;


    List<TaskItem> TaskList;
    Context _Context;

    public TasksAdapter(Context context, List<TaskItem> items){
        _Context = context;
        TaskList = items;
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType == DAY_OF_WEEK_VIEW){
            View dayView = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_task_day_item, parent, false);
            return new DayOfWeekViewHolder(dayView);
        } else {
            View taskView = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_task_list_item, parent, false);
            return new TaskItemViewHolder(taskView);
        }
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
        holder.bindView(position);
    }

    @Override
    public int getItemCount() {
        return 200;
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? DAY_OF_WEEK_VIEW : TASK_ITEM_VIEW;
    }



    public class DayOfWeekViewHolder extends BaseHolder {

        public DayOfWeekViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bindView(int position) {

        }

        @Override
        public void onClick(View v) {
            Toast.makeText(_Context, "You touched a day", Toast.LENGTH_LONG).show();
        }
    }

    public class TaskItemViewHolder extends BaseHolder {

        public TaskItemViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bindView(int position) {

        }

        @Override
        public void onClick(View v) {
            Toast.makeText(_Context, "You Touched a task", Toast.LENGTH_LONG).show();
        }
    }

    public abstract class BaseHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public BaseHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        public abstract void bindView(int position);
    }
}
