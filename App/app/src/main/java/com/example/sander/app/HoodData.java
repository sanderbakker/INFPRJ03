package com.example.sander.app;

/**
 * Created by Sander on 11-4-2017.
 * Creates custom ArrayList for the GraphView
 */

public class HoodData {
    public Double percentage;
    public Double max;
    public Double avg;
    public Integer hood;
    public Integer year;
    public String hood_name;
    public String table_name;
    public HoodData(Double p, Integer h, Integer y, String hN){
        percentage = p;
        hood = h;
        year = y;
        hood_name = hN;
    }
    public Double points;
    //max & avg is predetermined with sql queries
    public Double getPercentage(){
        if (getYear() == 2006){ max = 33.2; avg = 16.3;}
            else if (getYear() == 2007){ max = 29.5; avg = 16.4;}
                else if (getYear() == 2008){ max = 31.5; avg = 17.5;}
                    else if (getYear() == 2009){ max = 29.5; avg = 16.4;}
                        else if (getYear() == 2011){ max = 32.6; avg =  18.0;}
        ;
        max = max + (avg / 2);
        points = 100 - ((100 / max) * percentage);
        points = points / 20;
        return points;
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
