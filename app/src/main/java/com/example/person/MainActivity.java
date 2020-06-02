package com.example.person;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyAdapter.onItemClickListerner {


    DatabaseReference userdatabase;
    public RecyclerView mRecyclerView;
    public ArrayList<com.example.person.User> mUploads = new ArrayList<User>();
    public MyAdapter mAdapter;
    private RecyclerView.LayoutManager mLayout;
    public ChildEventListener childEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        userdatabase = firebaseDatabase.getReference().child("User");
        childEventListener = null;

        mAdapter = new MyAdapter(mUploads,getApplicationContext());
        mLayout = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayout);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(MainActivity.this);

        BackendFirebase bf = new BackendFirebase();
        bf.attachDatabaseReadListener(mAdapter, mUploads, childEventListener, getApplicationContext(), userdatabase);
    }

    @Override
    public void onItemClick(int position) {
        Log.d("ID of User **********",mUploads.get(position).getId());
        Intent i = new Intent(getApplicationContext(),ClickOnUser.class);
        i.putExtra("id",mUploads.get(position).getId());
        startActivity(i);
    }
}
