package com.gursimran.appstore;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;


public class refragment extends Fragment {



    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView,recyclerViewGame,recyclerViewBook;
    myadapter adapter,adapterGame,adapterBook;

    public refragment() {

    }



    public static refragment newInstance(String param1, String param2) {
        refragment fragment = new refragment();
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

        View view= inflater.inflate(R.layout.fragment_refragment, container, false);
        recyclerView=view.findViewById(R.id.app_recycler_view);
        recyclerViewGame=view.findViewById(R.id.games_recycler_view);
        recyclerViewBook=view.findViewById(R.id.books_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        FirebaseRecyclerOptions<Model> options =
                new FirebaseRecyclerOptions.Builder<Model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("App"), Model.class)
                        .build();
        adapter=new myadapter(options);
        recyclerView.setAdapter(adapter);
        recyclerViewGame.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        FirebaseRecyclerOptions<Model> optionsGame =
                new FirebaseRecyclerOptions.Builder<Model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Game"), Model.class)
                        .build();
        adapterGame=new myadapter(optionsGame);
        recyclerViewGame.setAdapter(adapterGame);
        recyclerViewBook.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        FirebaseRecyclerOptions<Model> optionsBook =
                new FirebaseRecyclerOptions.Builder<Model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Book"), Model.class)
                        .build();
        adapterBook=new myadapter(optionsBook);
        recyclerViewBook.setAdapter(adapterBook);




        return view;

    }
    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
        adapterBook.startListening();
        adapterGame.startListening();
    }
    @Override
    public void onStop() {
        super.onStop();
        adapter.startListening();
        adapterGame.startListening();
        adapterBook.stopListening();
    }

}