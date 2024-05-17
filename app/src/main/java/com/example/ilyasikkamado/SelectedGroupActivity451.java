package com.example.ilyasikkamado;

import static java.security.AccessController.getContext;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SelectedGroupActivity451 extends AppCompatActivity {
    ImageView back_btn;
    Button all_group, disability_group, siroti_group, incomplete_family, svo_group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_selected_group451);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        getWindow().setStatusBarColor(ContextCompat.getColor(SelectedGroupActivity451.this, R.color.statusBarColor));
        back_btn = findViewById(R.id.back_btn);
        all_group = findViewById(R.id.all_group);
        disability_group = findViewById(R.id.disability_group);
        siroti_group = findViewById(R.id.siroti_group);
        incomplete_family = findViewById(R.id.family_group);
        svo_group = findViewById(R.id.svo_group);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(SelectedGroupActivity451.this, GroupsActivity.class);
                startActivity(back);
                finish();
            }
        });

        all_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent all_group = new Intent(SelectedGroupActivity451.this, SelectedStudentActivity.class);
                all_group.putExtra("a1", "all");
                startActivity(all_group);

            }
        });

        disability_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent disability_group = new Intent(SelectedGroupActivity451.this, SelectedStudentActivity.class);
                disability_group.putExtra("a1", "disability");
                startActivity(disability_group);

            }
        });

        siroti_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siroti_group = new Intent(SelectedGroupActivity451.this, SelectedStudentActivity.class);
                siroti_group.putExtra("a1", "guardianship");
                startActivity(siroti_group);
            }
        });

        incomplete_family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent incomplete_family = new Intent(SelectedGroupActivity451.this, SelectedStudentActivity.class);
                incomplete_family.putExtra("a1", "incomplete_family");
                startActivity(incomplete_family);
            }
        });

        svo_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent svo_group = new Intent(SelectedGroupActivity451.this, SelectedStudentActivity.class);
                svo_group.putExtra("a1", "svo_group");
                startActivity(svo_group);
            }
        });













    }

}