package com.example.noteapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android2drawer.R;
import com.example.android2drawer.databinding.FragmentFormBinding;
import com.example.noteapp.model.TaskModel;

import org.jetbrains.annotations.NotNull;


public class FormFragment extends Fragment {
    private FragmentFormBinding binding;
    private NavController navController;
    TaskModel taskModel;

    public FormFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFormBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupListener();
    }

    private void setupListener() {
        onClickReady();
    }

    private void onClickReady() {
        binding.txtReady.setOnClickListener(v -> {
            btnSave();
        });
    }

    private void btnSave() {
        String title = binding.etTitle.getText().toString();
        taskModel = new TaskModel(title);
        Bundle bundle = new Bundle();
        bundle.putSerializable("model", taskModel);
        getParentFragmentManager().setFragmentResult("task", bundle);
        navController = Navigation.findNavController(requireActivity(),R.id.nav_host_fragment_content_main);
        navController.navigateUp();
    }
}