package com.govind.strathclydeadmin.faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.govind.strathclydeadmin.R;

import java.util.ArrayList;
import java.util.List;

public class UpdateFaculty extends AppCompatActivity {
    FloatingActionButton fab;
    private RecyclerView engineeringTeacher,humanitiesTeacher, scienceTeacher, businessTeacher,others;
    private LinearLayout engineeringNoData, humanitiesNoData, scienceNoData, businessNoData,   othersNoData;
    private List<TeacherData> list1, list2, list3, list4, list5;
    private TeacherAdapter adapter;

    private DatabaseReference reference, dbRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);

        engineeringTeacher = findViewById(R.id.engineeringTeacher);
        humanitiesTeacher = findViewById(R.id.humanitiesTeacher);
        scienceTeacher = findViewById(R.id.scienceTeacher);
        businessTeacher = findViewById(R.id.businessTeacher);
        others = findViewById(R.id.others);


        engineeringNoData = findViewById(R.id.engineeringNoData);
        humanitiesNoData = findViewById(R.id.humanitiesNoData);
        scienceNoData = findViewById(R.id.scienceNoData);
        businessNoData = findViewById(R.id.businessNoData);
        othersNoData = findViewById(R.id.othersNoData);


        reference = FirebaseDatabase.getInstance().getReference().child("teacher");


        engineeringTeacher();
        humanitiesTeacher();
        scienceTeacher();
        businessTeacher();

        others();


        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UpdateFaculty.this, AddTeachers.class));
            }
        });
    }

    private void engineeringTeacher() {
        dbRef = reference.child("Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    engineeringNoData.setVisibility(View.VISIBLE);
                    engineeringTeacher.setVisibility(View.GONE);
                }else {
                    engineeringNoData.setVisibility(View.GONE);
                    engineeringTeacher.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    engineeringTeacher.setHasFixedSize(true);
                    engineeringTeacher.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list1, UpdateFaculty.this, "Engineering");
                    engineeringTeacher.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void humanitiesTeacher() {
        dbRef = reference.child("Humanities and Social Sciences");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    humanitiesNoData.setVisibility(View.VISIBLE);
                    humanitiesTeacher.setVisibility(View.GONE);
                }else {
                    humanitiesNoData.setVisibility(View.GONE);
                    humanitiesTeacher.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    humanitiesTeacher.setHasFixedSize(true);
                    humanitiesTeacher.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list2, UpdateFaculty.this, "Humanities and Social Sciences");
                    humanitiesTeacher.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void scienceTeacher() {
        dbRef = reference.child("Science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    scienceNoData.setVisibility(View.VISIBLE);
                    scienceTeacher.setVisibility(View.GONE);
                }else {
                    scienceNoData.setVisibility(View.GONE);
                    scienceTeacher.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    scienceTeacher.setHasFixedSize(true);
                    scienceTeacher.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list3, UpdateFaculty.this,"Science");
                    scienceTeacher.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void businessTeacher() {
        dbRef = reference.child("Strathclyde Business School");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    businessNoData.setVisibility(View.VISIBLE);
                    businessTeacher.setVisibility(View.GONE);
                }else {
                    businessNoData.setVisibility(View.GONE);
                    businessTeacher.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    businessTeacher.setHasFixedSize(true);
                    businessTeacher.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list4, UpdateFaculty.this,"Strathclyde Business School");
                    businessTeacher.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void others() {
        dbRef = reference.child("Others");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    othersNoData.setVisibility(View.VISIBLE);
                    others.setVisibility(View.GONE);
                }else {
                    othersNoData.setVisibility(View.GONE);
                    others.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list5.add(data);
                    }
                    others.setHasFixedSize(true);
                    others.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list5, UpdateFaculty.this,"Others");
                    others.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}