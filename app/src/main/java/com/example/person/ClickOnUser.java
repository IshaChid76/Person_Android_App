package com.example.person;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;

public class ClickOnUser extends AppCompatActivity {

    String id;
    TextView textView_name, textView_website, textView_username, textView_email, textView_phone_no, textView_company_bs,
            textView_company_name, textView_company_catch_phrase, textView_address_city, textView_address_street, textView_address_suite,
            textView_address_zipcode;
    Button button_map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_on_user);

        this.getWindow().setBackgroundDrawableResource(R.color.pale);

        textView_name = (TextView) findViewById(R.id.textView_name);
        textView_website = (TextView) findViewById(R.id.textView_website);
        textView_username = (TextView) findViewById(R.id.textView_username);
        textView_email = (TextView) findViewById(R.id.textView_email);
        textView_phone_no = (TextView) findViewById(R.id.textView_phone_no);
        textView_company_bs = (TextView) findViewById(R.id.textView_company_bs);
        textView_company_catch_phrase = (TextView) findViewById(R.id.textView_company_catch_phrase);
        textView_company_name = (TextView) findViewById(R.id.textView_company_name);
        textView_address_city = (TextView) findViewById(R.id.textView_address_city);
        textView_address_street = (TextView) findViewById(R.id.textView_address_street);
        textView_address_suite = (TextView) findViewById(R.id.textView_address_suite);
        textView_address_zipcode = (TextView) findViewById(R.id.textView_address_zipcode);
        button_map = (Button) findViewById(R.id.button_map);

        if (getIntent() != null) {
            id = getIntent().getStringExtra("id");
            if (!id.isEmpty()) {
                BackendFirebase bf = new BackendFirebase();
                bf.getData(id, textView_name, textView_website, textView_username, textView_email, textView_phone_no,
                        textView_company_bs, textView_company_catch_phrase, textView_company_name, textView_address_city, textView_address_street,
                        textView_address_suite, textView_address_zipcode);
            }
        }

        button_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCoordinates(id);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }

    public void display(Address add, Company comp, User ui, TextView textView_name, TextView textView_website, TextView textView_username,
                        TextView textView_email, TextView textView_phone_no, TextView textView_company_bs, TextView textView_company_catch_phrase,
                        TextView textView_company_name, TextView textView_address_city, TextView textView_address_street,
                        TextView textView_address_suite, TextView textView_address_zipcode) {

        textView_name.setText(ui.getName());
        textView_website.setText(ui.getWebsite());
        textView_email.setText(ui.getEmail());
        textView_phone_no.setText(ui.getPhone());
        textView_company_bs.setText(comp.getBs());
        textView_company_catch_phrase.setText(comp.getCatchPhrase());
        textView_company_name.setText(comp.getName());
        textView_address_city.setText(add.getCity());
        textView_address_street.setText(add.getStreet());
        textView_address_suite.setText(add.getSuite());
        textView_address_zipcode.setText(add.getZipcode());
        textView_username.setText(ui.getUsername());
    }

    public void getCoordinates(String id){
        DatabaseReference userdatabase = FirebaseDatabase.getInstance().getReference("User");
        userdatabase.child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DataSnapshot geo = dataSnapshot.child("address").child("geo");
                Geo map = geo.getValue(Geo.class);

                if(map != null){
                    String Latitude = map.getLat();
                    String Logitude = map.getLng();
                    float lat = Float.parseFloat(Latitude);
                    float lng = Float.parseFloat(Logitude);

                    String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?q=loc:%f,%f", lat, lng);
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}