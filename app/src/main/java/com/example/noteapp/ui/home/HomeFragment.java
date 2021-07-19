package com.example.noteapp.ui.home;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.example.android2drawer.databinding.FragmentHomeBinding;
import com.example.noteapp.model.TaskModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ArrayList<TaskModel> taskModelList = new ArrayList<>();
    private HomeAdapter taskAdapter = new HomeAdapter();
    private FragmentHomeBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        setAdapter();
        setResultListener();
        setOnClickListrener();
        return root;
    }

    private void setOnClickListrener() {
        binding.searchEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }
    private void filter(String text){
        ArrayList<TaskModel> fildredList = new ArrayList<>();

        for (TaskModel model: taskModelList){
            if (model.getTitle().toLowerCase().contains(text.toLowerCase())) {
                fildredList.add(model);
            }
        }

        taskAdapter.filterList(fildredList);
    }

    public void setAdapter(){
        binding.rv.setAdapter(taskAdapter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;

    }

    private void setResultListener() {
        getParentFragmentManager().setFragmentResultListener("task",
                getViewLifecycleOwner(),
                new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        TaskModel taskModel = (TaskModel) result.getSerializable("model");
                        Log.e("tag", taskModel.getTitle());
                        taskModelList.add(taskModel);
                            taskAdapter.addInfo(taskModel);
                    }
                });
    }
}