package com.example.android.quakereport;

/**
 * Created by anirudh on 18/6/17.
 */

public class Earthquakes {
    private double magnitude;
    private String Location;
    private long timeInMiliSeconds;
    private String URL;
    public double getMagnitude(){
        return magnitude;
    }
    public String getLocation(){
        return Location;
    }
    public long getDateTime(){
        return timeInMiliSeconds;
    }
    public String getURL(){ return URL;}
    Earthquakes(double m,String l,long d,String URL){
        magnitude = m;
        Location = l;
        timeInMiliSeconds = d;
        this.URL = URL;
    }
    public void add(double m,String l,long d,String URL){
        magnitude = m;
        Location = l;
        timeInMiliSeconds = d;
        this.URL = URL;
    }
}
