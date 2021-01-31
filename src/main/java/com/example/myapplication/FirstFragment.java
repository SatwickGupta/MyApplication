package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;

import static android.content.Intent.ACTION_VIEW;

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {


   View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_first, container, false);
        return view;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button b=view.findViewById(R.id.btnYoutube);
        Button fb=view.findViewById(R.id.btnFaceBook);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://youtube.com";
                Uri webpage=Uri.parse(url);
                Intent intent=new Intent(ACTION_VIEW,webpage);
                startActivity(intent);
            }
        });
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://fb.com";
                Uri webpage=Uri.parse(url);
                Intent intent=new Intent(ACTION_VIEW,webpage);
                startActivity(intent);
            }
        });
    }
}