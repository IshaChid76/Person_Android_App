package com.example.person;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BackendFirebase {

    DatabaseReference userdatabase;

    public void attachDatabaseReadListener(final MyAdapter mAdapter, final ArrayList<User> mUploads1,
                                           ChildEventListener childEventListener, final Context context, DatabaseReference userdatabase1){
        if(childEventListener==null){
            childEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    User user = dataSnapshot.getValue(User.class);
                    mUploads1.add(0, user);
                    mAdapter.notifyDataSetChanged();

                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    User user = dataSnapshot.getValue(User.class);
                    mUploads1.add(user);
                    mAdapter.notifyDataSetChanged();
                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {}

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    User user = dataSnapshot.getValue(User.class);
                    mUploads1.add(user);
                    mAdapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(context,databaseError.toString(), Toast.LENGTH_SHORT).show();
                }
            };
            userdatabase1.addChildEventListener(childEventListener);
        }
    }

    public void getData(String id, final TextView textView_name, final TextView textView_website, final TextView textView_username,
                        final TextView textView_email, final TextView textView_phone_no, final TextView textView_company_bs,
                        final TextView textView_company_catch_phrase, final TextView textView_company_name, final TextView textView_address_city,
                        final TextView textView_address_street, final TextView textView_address_suite, final TextView textView_address_zipcode){

        userdatabase = FirebaseDatabase.getInstance().getReference("User");
        userdatabase.child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User ui = dataSnapshot.getValue(User.class);
                DataSnapshot company = dataSnapshot.child("company");
                DataSnapshot address = dataSnapshot.child("address");
                Company comp = company.getValue(Company.class);
                Address add = address.getValue(Address.class);
                ClickOnUser cou = new ClickOnUser();

                if (ui != null) {
                    cou.display(add, comp, ui, textView_name, textView_website, textView_username, textView_email,
                            textView_phone_no, textView_company_bs, textView_company_catch_phrase, textView_company_name, textView_address_city,
                            textView_address_street, textView_address_suite, textView_address_zipcode);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
