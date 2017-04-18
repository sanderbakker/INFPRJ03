package com.example.sander.app;

/**
 * Created by Sander on 15-4-2017.
 */

public class Points {
    String hoodName;
    Double points;
    Integer hoodId;
    public Points(String hN, Double p, Integer hI){
        hoodName = hN;
        points =p;
        hoodId = hI;
    }

    public Double getPoints() {
        return points;
    }

    public Integer getHoodId() {
        return hoodId;
    }

    public String getHoodName() {
        return hoodName;
    }
}
