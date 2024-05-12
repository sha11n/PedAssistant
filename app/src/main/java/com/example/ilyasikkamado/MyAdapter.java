package com.example.ilyasikkamado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Student> list;

    public MyAdapter(Context context, ArrayList<Student> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position){
        Student student = list.get(position);
        holder.accounting.setText(student.getAccounting());
        holder.anothersvo.setText(student.getAnothersvo());
        holder.birthday.setText(student.getBirthday());
        holder.citizenship.setText(student.getCitizenship());
        holder.director.setText(student.getDirector());
        holder.family.setText(student.getFamily());
        holder.guardianship.setText(student.getGuardianship());
        holder.habitation.setText(student.getHabitation());
        holder.health.setText(student.getHealth());
        holder.hobby.setText(student.getHobby());
        holder.name.setText(student.getName());
        holder.residence.setText(student.getResidence());
        holder.scholarship.setText(student.getScholarship());
        holder.sex.setText(student.getSex());
        holder.svo.setText(student.getSvo());
        holder.disability_info.setText(student.getDisability_info());

    }

    @Override
    public int getItemCount(){
        return list.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{


        TextView accounting, anothersvo, birthday, citizenship, director, family, guardianship, habitation, health, hobby, name, residence, scholarship, sex, svo, disability_info;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            accounting = itemView.findViewById(R.id.tvstudent_accounting);
            anothersvo = itemView.findViewById(R.id.tvstudent_anothersvo);
            birthday = itemView.findViewById(R.id.tvstudent_birthday);
            citizenship = itemView.findViewById(R.id.tvstudent_citizenship);
            director = itemView.findViewById(R.id.tvstudent_director);
            family = itemView.findViewById(R.id.tvstudent_family);
            guardianship = itemView.findViewById(R.id.tvstudent_guardianship);
            health = itemView.findViewById(R.id.tvstudent_health);
            habitation = itemView.findViewById(R.id.tvstudent_habitation);
            hobby = itemView.findViewById(R.id.tvstudent_hobby);
            name = itemView.findViewById(R.id.tvstudent_name);
            residence = itemView.findViewById(R.id.tvstudent_residence);
            scholarship = itemView.findViewById(R.id.tvstudent_scholarship);
            sex = itemView.findViewById(R.id.tvstudent_sex);
            svo = itemView.findViewById(R.id.tvstudent_svo);
            disability_info = itemView.findViewById(R.id.tvstudent_disability_info);

        }
    }

}
