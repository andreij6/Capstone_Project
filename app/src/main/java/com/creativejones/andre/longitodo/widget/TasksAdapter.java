package com.creativejones.andre.longitodo.widget;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.creativejones.andre.longitodo.R;
import com.creativejones.andre.longitodo.models.TaskItem;
import com.creativejones.andre.longitodo.viewmodels.TaskItemVM;

import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.BaseHolder> {

    private static final int DAY_OF_WEEK_VIEW = 333;
    private static final int TASK_ITEM_VIEW = 444;

    static List<TaskItem> TaskList;
    static Context _Context;
    static AdapterInteractionListener Listener;

    public TasksAdapter(Context context, List<TaskItem> items){
        _Context = context;
        TaskList = items;
        Listener = (AdapterInteractionListener)context;

    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return viewType == DAY_OF_WEEK_VIEW ? DayOfWeekViewHolder.newInstance(parent) : TaskItemViewHolder.newInstance(parent);
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

    public static class TaskItemViewHolder extends BaseHolder {

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
            Name.setOnClickListener(goToTaskDetail());

            Category.setText(viewModel.getCategory());
            Category.setOnClickListener(goToTaskDetail());

            LocationIcon.setOnClickListener(goToTaskDetail());
            LocationIcon.setVisibility(viewModel.hasLocation() ? View.VISIBLE : View.GONE);

            TaskCheckBox.setChecked(viewModel.isCompleted());
            TaskCheckBox.setOnCheckedChangeListener(taskCheckedListener());
        }

        private CompoundButton.OnCheckedChangeListener taskCheckedListener(){
            return new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked)
                        viewModel.markAsComplete();
                }
            };
        }

        private View.OnClickListener goToTaskDetail(){
            return new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    if(Listener != null)
                        Listener.onShowTaskDetailInteration(viewModel);
                }
            };
        }

        public static BaseHolder newInstance(ViewGroup parent) {
            View taskView = createView(parent, R.layout.main_task_list_item);
            return new TaskItemViewHolder(taskView);
        }
    }

    public static class DayOfWeekViewHolder extends BaseHolder {

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

        public static BaseHolder newInstance(ViewGroup parent) {
            View dayView = createView(parent, R.layout.main_task_day_item);
            return new DayOfWeekViewHolder(dayView);
        }
    }

    public abstract static class BaseHolder extends RecyclerView.ViewHolder {

        public BaseHolder(View itemView) {
            super(itemView);
            ViewReferences();
        }

        public abstract void bindView(int position);

        protected abstract void ViewReferences();

        protected static View createView(ViewGroup parent, int layoutId){
            return LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        }
    }

    public interface AdapterInteractionListener {
        void onShowTaskDetailInteration(TaskItemVM viewModel);
    }
}
