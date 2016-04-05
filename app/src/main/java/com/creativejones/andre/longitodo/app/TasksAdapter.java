package com.creativejones.andre.longitodo.app;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.creativejones.andre.longitodo.R;
import com.creativejones.andre.longitodo.models.TaskItem;
import com.creativejones.andre.longitodo.viewmodels.TaskItemVM;

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
        return 40;
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? DAY_OF_WEEK_VIEW : TASK_ITEM_VIEW;
    }

    public class DayOfWeekViewHolder extends BaseHolder {

        TextView DateTextView;

        public DayOfWeekViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bindView(int position) {
            DateTextView.setText("Monday");
        }

        @Override
        protected void ViewReferences() {
            DateTextView = (TextView) itemView.findViewById(R.id.task_date_TV);
        }

    }

    public class TaskItemViewHolder extends BaseHolder {

        View Priority;
        TextView Name, Category;
        CheckBox TaskCheckBox;
        ImageView LocationIcon;

        TaskItemVM viewModel;

        public TaskItemViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void ViewReferences() {
            Priority = itemView.findViewById(R.id.recycler_task_priority);
            Name = (TextView) itemView.findViewById(R.id.recycler_task_name_textview);
            Category = (TextView) itemView.findViewById(R.id.recycler_task_category_textview);
            TaskCheckBox = (CheckBox) itemView.findViewById(R.id.recycler_task_checkbox);
            LocationIcon = (ImageView) itemView.findViewById(R.id.recycler_task_location_icon);
        }

        @Override
        public void bindView(int position) {
            viewModel = TaskList.get(0).toViewModel();

            Priority.setBackgroundColor(ContextCompat.getColor(_Context, viewModel.getPriority()));
            Name.setText(viewModel.getName());
            Category.setText(viewModel.getCategory());

            Name.setOnClickListener(goToTaskDetail());
            Category.setOnClickListener(goToTaskDetail());

            LocationIcon.setVisibility(viewModel.hasLocation() ? View.VISIBLE : View.GONE);

            TaskCheckBox.setChecked(viewModel.isCompleted());

            TaskCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        viewModel.markAsComplete();
                    }
                }
            });


            LocationIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(_Context, "Zoom to location", Toast.LENGTH_LONG).show();
                }
            });
        }

        private View.OnClickListener goToTaskDetail(){
            return new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Toast.makeText(_Context, "Go To Detail View", Toast.LENGTH_LONG).show();
                }
            };
        }

    }

    public abstract class BaseHolder extends RecyclerView.ViewHolder {

        public BaseHolder(View itemView) {
            super(itemView);
            ViewReferences();
        }

        public abstract void bindView(int position);

        protected abstract void ViewReferences();
    }
}
