package com.fragments.bottomnavassignment.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fragments.bottomnavassignment.R;
import com.fragments.bottomnavassignment.ui.student.StudentViewModel;

import org.w3c.dom.Text;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentDetails> implements View.OnClickListener {

    Context context;
    List<StudentViewModel>studentViewModelList;
    private int position;

    public StudentAdapter(Context context, List<StudentViewModel> studentViewModelList) {
        this.context = context;
        this.studentViewModelList = studentViewModelList;
    }

    @NonNull
    @Override
    public StudentDetails onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview,parent,false);
        return new StudentDetails(view);

    }

    @Override
    public void onBindViewHolder(@NonNull StudentDetails holder, int position) {
     StudentViewModel studentModel=studentViewModelList.get(position);
     if(studentModel.getGender().equalsIgnoreCase("male")){
         holder.Images.setImageResource(R.drawable.man);
     }
     else if (studentModel.getGender().equalsIgnoreCase("female")){
         holder.Images.setImageResource(R.drawable.woman);
     }
     else {
         holder.Images.setImageResource(R.drawable.bigender);
     }
        holder.tvName.setText(studentModel.getName());
        holder.tvAge.setText(studentModel.getAge());
        holder.tvAddress.setText(studentModel.getAddress());
        holder.tvGender.setText(studentModel.getGender());
        holder.btnDelete.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return studentViewModelList.size();
    }

    @Override
    public void onClick(View v) {
        studentViewModelList.remove(position);
        notifyDataSetChanged();
    }

    

    public class StudentDetails extends RecyclerView.ViewHolder {
        ImageView Images;
        TextView tvName,tvAge,tvAddress,tvGender;
        Button btnDelete;
        public StudentDetails(@NonNull View itemView) {
            super(itemView);

            Images=itemView.findViewById(R.id.Images);
            tvName=itemView.findViewById(R.id.tvName);
            tvAge=itemView.findViewById(R.id.tvAge);
            tvAddress=itemView.findViewById(R.id.tvAddress);
            tvGender=itemView.findViewById(R.id.tvGender);
            btnDelete= itemView.findViewById(R.id.btnDelete);
        }
    }
}
