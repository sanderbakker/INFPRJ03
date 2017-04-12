package com.example.sander.app;

/**
 * Created by Sander on 11-4-2017.
 */

public class HoodData {
    public Double percentage;
    public Integer hood;
    public Integer year;
    public String hood_name;
    public HoodData(Double p, Integer h, Integer y, String hN){
        percentage = p;
        hood = h;
        year = y;
        hood_name = hN;
    }
    public Double getPercentage(){
        return percentage;
    }
    public Integer getHood(){
        return hood;
    }
    public Integer getYear(){
        return year;
    }

    public String getHood_name() {
        return hood_name;
    }
}
