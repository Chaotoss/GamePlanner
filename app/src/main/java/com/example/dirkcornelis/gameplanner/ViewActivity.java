package com.example.dirkcornelis.gameplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ViewActivity extends AppCompatActivity {
    private RecyclerView GameLijst;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Events");
        GameLijst = findViewById(R.id.GameLijst);
        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);
        LayoutManager.setReverseLayout(true);
        LayoutManager.setStackFromEnd(true);
        GameLijst.setHasFixedSize(true);
        GameLijst.setLayoutManager(LayoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.view_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.addEvent:
                Intent intent = new Intent(ViewActivity.this, CreateEventActivity.class);
                startActivity(intent);
                return true;
            case R.id.log_out:
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(getApplicationContext(), "Logout Successful!", Toast.LENGTH_LONG).show();
                Intent logoutIntent = new Intent(ViewActivity.this, MainActivity.class);
                logoutIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(logoutIntent);
                ViewActivity.this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onStart(){
        super.onStart();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null){
            Intent notLoggedIntent = new Intent(ViewActivity.this, MainActivity.class);
            startActivity(notLoggedIntent);
        }

        FirebaseRecyclerAdapter<GameEvent, GameLijst> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<GameEvent, ViewActivity.GameLijst>(

                GameEvent.class,
                R.layout.gamecard,
                GameLijst.class,
                mDatabase

        ) {
            @Override
            protected void populateViewHolder(ViewActivity.GameLijst viewHolder, GameEvent model, int position) {
                viewHolder.setGame(model.getGame());
                viewHolder.setDay(model.getDay());
                viewHolder.setTimeofday(model.getTimeofday());
                viewHolder.setUsername(model.username);
            }
        };
        GameLijst.setAdapter(firebaseRecyclerAdapter);
    }

    public static class GameLijst extends RecyclerView.ViewHolder{
        View mView;

        public GameLijst(View itemView){
            super(itemView);
            mView = itemView;
        }

        public void setGame(String game){
            TextView textGame = mView.findViewById(R.id.txtGame);
            textGame.setText(game);
            ImageView ImageLogo =  mView.findViewById(R.id.imageLogo);

            if (game.equals("Stick Fight")){
                ImageLogo.setImageResource(R.mipmap.stickfight);
            }else if (game.equals("League of Legends")){
                ImageLogo.setImageResource(R.mipmap.stickfight);
            }else if (game.equals("PlayerUnknown Battlegrounds")){
                ImageLogo.setImageResource(R.mipmap.stickfight);
            }else if (game.equals("Totally Acurate Battlegrounds")){
                ImageLogo.setImageResource(R.mipmap.stickfight);
            }else if (game.equals("Stellaris")){
                ImageLogo.setImageResource(R.mipmap.stickfight);
            }else{
                ImageLogo.setImageResource(R.mipmap.stickfight);
            }

        }

        public void setDay(String day){
            TextView textDay = mView.findViewById(R.id.txtDay);
            textDay.setText(day);
        }

        public void setTimeofday(String timeofday){
            TextView textToD = mView.findViewById(R.id.txtToD);
            textToD.setText(timeofday);
        }

        public void setUsername(String username){
            TextView textCreator = mView.findViewById(R.id.txtCreator);
            textCreator.setText(username);
        }
    }


}
