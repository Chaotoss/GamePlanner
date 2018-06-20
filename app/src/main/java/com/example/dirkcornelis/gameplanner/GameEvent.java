package com.example.dirkcornelis.gameplanner;

public class GameEvent {
    public String game;
    public String day;
    public String timeofday;
    public String username;

    public GameEvent() {
    }

    public GameEvent(String game, String day, String timeofday, String username) {
        this.game = game;
        this.day = day;
        this.timeofday = timeofday;
        this.username = username;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTimeofday() {
        return timeofday;
    }

    public void setTimeofday(String timeofday) {
        this.timeofday = timeofday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}