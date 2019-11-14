package com.fragments.bottomnavassignment.ui.student;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.fragments.bottomnavassignment.R;

import java.util.ArrayList;
import java.util.List;

public class StudentFragment extends Fragment implements View.OnClickListener {

    private StudentViewModel studentViewModel;
    private EditText stname,age,address;
    private Button btnsave;
    private RadioGroup group;
    String name = "", ages = "", addss = "", gender = "";
    List<StudentViewModel> studentList = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
        ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_student, container, false);
      stname=root.findViewById(R.id.StName);
        age=root.findViewById(R.id.Age);
        address=root.findViewById(R.id.Address);
        group=root.findViewById(R.id.grp);
        btnsave=root.findViewById(R.id.btnSave);
        btnsave.setOnClickListener(this);


        return root;
    }

    @Override
    public void onClick(View v) {


        if (TextUtils.isEmpty(stname.getText().toString())) {
            stname.setError("please enter name");
            return;
        } else if (TextUtils.isEmpty(address.getText().toString())) {
            address.setError("please enter address");
            return;
        } else if (TextUtils.isEmpty(age.getText().toString())) {
            age.setError("please enter age");
        } else {
            name = stname.getText().toString();
            addss = address.getText().toString();
            ages = age.getText().toString();
        }

        int selectid =group.getCheckedRadioButtonId();
        if (selectid > 0) {
            RadioButton radioButton = getView().findViewById(selectid);
             gender= radioButton.getText().toString();
            Toast.makeText(getContext(), "Welcome " + name + ages + addss + gender, Toast.LENGTH_SHORT).show();
            StudentViewModel sm= new StudentViewModel(name,addss,ages,gender);
            studentList=sm.getLists();
            studentList.add(sm);
            sm.setLists(studentList);
            stname.setText("");
            address.setText("");
            age.setText("");
            radioButton.setChecked(false);
        } else {
            Toast.makeText(getContext(), "Please select gender", Toast.LENGTH_SHORT).show();
        }

    }
}