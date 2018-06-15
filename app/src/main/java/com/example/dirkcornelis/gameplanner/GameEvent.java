package com.example.dirkcornelis.gameplanner;

import com.google.firebase.database.DatabaseReference;

public class GameEvent {
    public String Game;
    public String Day;
    public String TimeOfDay;

    public GameEvent(String Game, String Day, String TimeOfDay){
        this.Game = Game;
        this.Day = Day;
        this.TimeOfDay = TimeOfDay;
    }
}