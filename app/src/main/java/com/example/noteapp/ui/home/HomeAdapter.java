package com.example.noteapp.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android2drawer.R;
import com.example.noteapp.model.TaskModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HolderTask>{
    private ArrayList<TaskModel> taskModelList = new ArrayList<>();

    @NonNull
    @NotNull
    @Override
    public HomeAdapter.HolderTask onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new HolderTask(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull HomeAdapter.HolderTask holder, int position) {
        holder.bind(taskModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return taskModelList.size();
    }

    public void addInfo(TaskModel taskModel) {
        taskModelList.add(taskModel);
        notifyDataSetChanged();
    }

    public void filterList(ArrayList<TaskModel> fildredList) {
        taskModelList = fildredList;
        notifyDataSetChanged();
    }

    public class HolderTask extends RecyclerView.ViewHolder {
        TextView tvTitle;
        public HolderTask(@NonNull @NotNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.item_title);
        }

        public void bind(TaskModel taskModel) {
            tvTitle.setText(taskModel.getTitle());
        }
    }
}
