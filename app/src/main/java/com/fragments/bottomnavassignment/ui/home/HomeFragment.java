package com.fragments.bottomnavassignment.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fragments.bottomnavassignment.R;
import com.fragments.bottomnavassignment.adapter.StudentAdapter;
import com.fragments.bottomnavassignment.ui.student.StudentViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    public RecyclerView recyclerView;

    List<StudentViewModel> studentList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = root.findViewById(R.id.rcView);
        StudentViewModel st = new StudentViewModel("Sabeena", "17", "ktm", "Female");

        studentList = st.getLists();
        if (studentList.isEmpty()) {
            studentList.add(st);
            studentList.add(new StudentViewModel("Shyam", "23", "ktm", "Male"));
            st.setLists(studentList);
        }

        StudentAdapter studentAdapter = new StudentAdapter(getActivity(), studentList);
        recyclerView.setAdapter(studentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return root;
    }
}