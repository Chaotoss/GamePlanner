package com.example.dirkcornelis.gameplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {
    Button createBtn, viewBtn, profileBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        createBtn = findViewById(R.id.createBtn);
        viewBtn = findViewById(R.id.viewBtn);
        profileBtn = findViewById(R.id.profileBtn);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null){
            Intent notLoggedIntent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(notLoggedIntent);
        }else{
            Toast.makeText(getApplicationContext(), "User: " + user, Toast.LENGTH_LONG).show();
        }


        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createEventIntent = new Intent(HomeActivity.this, CreateEventActivity.class);
                startActivity(createEventIntent);
            }
        });

        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewEventsIntent = new Intent(HomeActivity.this, CreateEventActivity.class);
                startActivity(viewEventsIntent);
            }
        });

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewProfileIntent = new Intent(HomeActivity.this, CreateEventActivity.class);
                startActivity(viewProfileIntent);
            }
        });
    }
}
