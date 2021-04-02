package com.gursimran.appstore;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class show_data extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    String appName,category,imageUrl;
    ImageView imageView;
    TextView name,cat;
    Button back;
    private Object AppCompatActivity;

    public show_data() {

    }
    public show_data(String appName,String category,String imageUrl) {
        this.appName=appName;
        this.category=category;
        this.imageUrl=imageUrl;

    }



    public static show_data newInstance(String param1, String param2) {
        show_data fragment = new show_data();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_show_data, container, false);
        imageView=view.findViewById(R.id.app_image);
        name=view.findViewById(R.id.name_app);
        cat=view.findViewById(R.id.category_app);
        back=view.findViewById(R.id.back_btn);
        name.setText(appName);
        cat.setText("Category Type-: "+category);
        Glide.with(getContext()).load(imageUrl).into(imageView);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backPressed();
            }
        });
        return view;
    }
    public void backPressed(){
        AppCompatActivity appCompatActivity=(AppCompatActivity)getContext();
        appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper,new refragment()).addToBackStack(null).commit();
    }
}