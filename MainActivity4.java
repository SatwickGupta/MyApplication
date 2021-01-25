package com.example.myapplication;

import android.os.Bundle;
import android.view.Display;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.ModelClass;
import com.example.recyclerview.ProgrammingAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {
    ProgrammingAdapter Adapter;
    RecyclerView recyclerView;
    List<ModelClass> userList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        initData();
        initRecyclerView();
    }



    private void initRecyclerView()
    {
        recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Adapter=new ProgrammingAdapter(userList);
        recyclerView.setAdapter(Adapter);
    }
    private void initData()
    {
        userList=new ArrayList<>();
        userList.add(new ModelClass(R.drawable.machadownload,"macha"));
        userList.add(new ModelClass(R.drawable.banjarahillsprasanth,"Banjara Hills Prasanth"));
        userList.add(new ModelClass(R.drawable.ayyagareno1jpg,"Ayyagare No1"));
        userList.add(new ModelClass(R.drawable.kagaznagarsaidownload,"Kagaznagar Sai"));
        userList.add(new ModelClass(R.drawable.anchorshiva,"Anchor Shiva"));
        userList.add(new ModelClass(R.drawable.sunsit,"Sacrificing Star"));
        userList.add(new ModelClass(R.drawable.uppalbalu,"love de  balu"));
        userList.add(new ModelClass(R.drawable.pittaladora,"pittala dora"));
        userList.add(new ModelClass(R.drawable.banjarahillsprasanth,"Banjara Hills Prasanth"));
        userList.add(new ModelClass(R.drawable.ayyagareno1jpg,"Ayyagare No1"));
        userList.add(new ModelClass(R.drawable.kagaznagarsaidownload,"Kagaznagar Sai"));


    }
}
