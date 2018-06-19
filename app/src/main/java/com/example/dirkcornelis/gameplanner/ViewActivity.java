package com.example.dirkcornelis.gameplanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
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
        GameLijst.setHasFixedSize(true);
        GameLijst.setLayoutManager(LayoutManager);
    }

    @Override
    protected void onStart(){
        super.onStart();

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
        }

        public void setDay(String day){
            TextView textDay = mView.findViewById(R.id.txtDay);
            textDay.setText(day);
        }

        public void setTimeofday(String timeofday){
            TextView textToD = mView.findViewById(R.id.txtToD);
            textToD.setText(timeofday);
        }
    }


}
