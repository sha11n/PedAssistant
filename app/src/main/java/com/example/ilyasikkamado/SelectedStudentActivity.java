package com.example.ilyasikkamado;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class SelectedStudentActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference database, dbDisability;
    MyAdapter myAdapter;
    ArrayList<Student> list;
    ImageView back_btn;
    String a1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_selected_student);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getWindow().setStatusBarColor(ContextCompat.getColor(SelectedStudentActivity.this, R.color.statusBarColor));


        back_btn = findViewById(R.id.back_btn);

        database = FirebaseDatabase.getInstance().getReference("Students");

        recyclerView = findViewById(R.id.studentsList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdapter = new MyAdapter(this, list);
        recyclerView.setAdapter(myAdapter);

        dbDisability = FirebaseDatabase.getInstance().getReference("Students");


//        Query queryDisability = FirebaseDatabase.getInstance().getReference("Students")
//                .orderByChild("disability")
//                .equalTo("есть");
//        queryDisability.addListenerForSingleValueEvent(valueEventListener);
//
//       Query queryGuardianship = FirebaseDatabase.getInstance().getReference("Students")
//               .orderByChild("guardianship")
//               .equalTo("сирота");
//       queryGuardianship.addListenerForSingleValueEvent(valueEventListener);


        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(SelectedStudentActivity.this, SelectedGroupActivity451.class);
                startActivity(back);
                onPause();
            }
        });
        // switch

    }

    @Override
    protected void onStart()
    {
        super.onStart();
        a1 = getIntent().getStringExtra("a1");
        String choose = a1;
        Query queryDisability = FirebaseDatabase.getInstance().getReference("Students")
                .orderByChild("disability")
                .equalTo("есть");
        queryDisability.addListenerForSingleValueEvent(valueEventListener);

        Query queryGuardianship = FirebaseDatabase.getInstance().getReference("Students")
                .orderByChild("guardianship")
                .equalTo("сирота");
        queryGuardianship.addListenerForSingleValueEvent(valueEventListener);
        switch (choose){
            case "all":
                database.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        list.clear();
                        for (DataSnapshot dataSnapshot :  snapshot.getChildren()){
                            Student student = dataSnapshot.getValue(Student.class);
                            list.add(student);
                        }
                        myAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            case "disability":
                queryDisability.addListenerForSingleValueEvent(valueEventListener);
            case "guardianship":
                queryGuardianship.addListenerForSingleValueEvent(valueEventListener);
        }
    }
    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            list.clear();
            for (DataSnapshot dataSnapshot :  snapshot.getChildren()){
                Student student = dataSnapshot.getValue(Student.class);
                list.add(student);
            }
            myAdapter.notifyDataSetChanged();
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };
}