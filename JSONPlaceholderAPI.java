package com.example.myapplication;
import com.example.myapplication.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceholderAPI {
    @GET("posts")
    Call<List<Post>> getPosts();
}
