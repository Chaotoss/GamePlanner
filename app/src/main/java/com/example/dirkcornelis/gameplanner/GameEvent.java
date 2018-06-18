package com.example.dirkcornelis.gameplanner;

import com.google.firebase.database.DatabaseReference;

public class GameEvent {
    public String Game;
    public String Day;
    public String TimeOfDay;

    public GameEvent(){

    }

    public String getGame() {
        return Game;
    }

    public void setGame(String game) {
        Game = game;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public String getTimeOfDay() {
        return TimeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        TimeOfDay = timeOfDay;
    }

    public GameEvent(String game, String day, String timeofday){
        this.Game = game;
        this.Day = day;
        this.TimeOfDay = timeofday;
    }
}