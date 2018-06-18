package com.example.dirkcornelis.gameplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateEventActivity extends AppCompatActivity {
    Spinner GameSpinner, DaySpinner, ToDSpinner;
    Button createEventBtn;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        GameSpinner = findViewById(R.id.gameSpinner);
        DaySpinner = findViewById(R.id.daySpinner);
        ToDSpinner = findViewById(R.id.ToDSpinner);
        createEventBtn = findViewById(R.id.createEventBtn);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null){
            Intent notLoggedIntent = new Intent(CreateEventActivity.this, MainActivity.class);
            startActivity(notLoggedIntent);
        }


        databaseReference = FirebaseDatabase.getInstance().getReference().child("Events");

        ArrayAdapter<String> GameAdapter = new ArrayAdapter<String>(CreateEventActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Game));
        ArrayAdapter<String> DayAdapter = new ArrayAdapter<String>(CreateEventActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.day));
        ArrayAdapter<String> ToDAdapter = new ArrayAdapter<String>(CreateEventActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.ToD));

        GameAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        DayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ToDAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        GameSpinner.setAdapter(GameAdapter);
        DaySpinner.setAdapter(DayAdapter);
        ToDSpinner.setAdapter(ToDAdapter);


        createEventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Game = GameSpinner.getSelectedItem().toString().trim();
                String Day = DaySpinner.getSelectedItem().toString().trim();
                String TimeOfDay = ToDSpinner.getSelectedItem().toString().trim();

                GameEvent gameEvent = new GameEvent(Game, Day, TimeOfDay);
                databaseReference.push().setValue(gameEvent).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getApplicationContext(), "Event successfully added!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(CreateEventActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });

    }
}
