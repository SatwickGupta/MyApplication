package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ProgrammingRecyclerview extends AppCompatActivity {
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
        userList.add(new ModelClass(R.drawable.ic_machadownload,"macha"));
        userList.add(new ModelClass(R.drawable.ic_banjarahillsprasanth,"Banjara Hills Prasanth"));
        userList.add(new ModelClass(R.drawable.ic_ayyagareno1jpg,"Ayyagare No1"));
        userList.add(new ModelClass(R.drawable.ic_kagaznagarsaidownload,"Kagaznagar Sai"));
        userList.add(new ModelClass(R.drawable.ic_anchorshiva,"Anchor Shiva"));
        userList.add(new ModelClass(R.drawable.ic_sunsit,"Sacrificing Star"));
        userList.add(new ModelClass(R.drawable.ic_uppalbalu,"love de  balu"));
        userList.add(new ModelClass(R.drawable.ic_pittaladora,"pittala dora"));
        userList.add(new ModelClass(R.drawable.ic_banjarahillsprasanth,"Banjara Hills Prasanth"));
        userList.add(new ModelClass(R.drawable.ic_ayyagareno1jpg,"Ayyagare No1"));
        userList.add(new ModelClass(R.drawable.ic_kagaznagarsaidownload,"Kagaznagar Sai"));


    }
}
