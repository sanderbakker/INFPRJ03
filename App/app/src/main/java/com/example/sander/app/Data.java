package com.example.sander.app;

import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Sander on 8-4-2017.
 */

public class Data {
    public String names;
    public String cPoints;
    public Double latitude;
    public Double longitude;
    public String code;
    public Float distance;
    public Data(String n, String cP, Double lat, Double lon, String c, Float dis ){
        names = n;
        cPoints = cP;
        latitude = lat;
        longitude = lon;
        code = c;
        distance = dis;
    }
    public String getNames(){
        return names;
    }
    public String getcPoints(){
        return cPoints;
    }
    public Double getLatitude(){
        return latitude;
    }
    public Double getLongitude(){
        return longitude;
    }
    public String getCode(){
        return code;
    }
    public Double getDistance(){
        return Math.ceil(distance);
    }


}

