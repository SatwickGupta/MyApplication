package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProgrammingRecyclerview extends AppCompatActivity {
    ProgrammingAdapter Adapter;
    RecyclerView recyclerView;
    /* List<String> Id;
     List<String> Name;
     List<String> Category;
     List<String> Country;
     List<String> Language;
     List<String> Description;
     List<String>  URL;
     */
     public List<Item> item;


   String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        // initData();
        // initRecyclerView();
        Intent intent = getIntent();
        name = intent.getStringExtra("CategorySelected");
        recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

       /*
        Id=new ArrayList<>();
        Name=new ArrayList<>();
        Category=new ArrayList<>();
        Country=new ArrayList<>();
        Language=new ArrayList<>();
        Description=new ArrayList<>();
        URL=new ArrayList<>();
        */
        item=new ArrayList<>();
        initData();
        Adapter=new ProgrammingAdapter(item);
        recyclerView.setAdapter(Adapter);

    }



    /*private void initRecyclerView()
    {
        recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Adapter=new ProgrammingAdapter(userList);
        recyclerView.setAdapter(Adapter);

    }
    */
    private void initData()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://saurav.tech/NewsAPI/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JSONPlaceholderAPI jsonPlaceholderAPI = retrofit.create(JSONPlaceholderAPI.class);

        Call<Model> call = jsonPlaceholderAPI.getPosts();
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {

                Model posts = response.body();
                for (Post post : posts.sources) {
                    if ( post.getcategory().equals(name)) {
                       /*Id.add("ID: "+ post.getId());
                       Name.add("Name :"+post.getName());
                       Category.add("Category: "+post.getcategory());
                       Language.add("Language: "+post.getLanguage());
                       Country.add("Country: "+post.getCountry());
                       Description.add("Description: "+post.getDescription());
                       URL.add("URL: "+post.getURL());
                       */
                        Item item1=new Item();
                        item1.setID("ID : "+post.getId());
                        item1.setName("Name : "+post.getName());
                        item1.setCategory("Category : "+post.getcategory());
                        item1.setLanguage("Langugage : "+post.getLanguage());
                        item1.setCountry("Country : "+post.getCountry());
                        item1.setDescription("Description : "+post.getDescription());
                        item1.setUrl("URL : "+post.getURL());
                        item.add(item1);


                    } else {
                        continue;
                    }
                }Adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {


            }
        });
    }
}
