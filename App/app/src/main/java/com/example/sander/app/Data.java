package com.example.sander.app;

import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Sander on 8-4-2017.
 * Custom ArrayList, for managing all the data from the API
 */

public class Data {
    public String names;
    public String cPoints;
    public Double latitude;
    public Double longitude;
    public String code;
    public Float distance;
    public Integer spots;
    public String zipcode;
    public String street;
    public String streetNumber;
    public String city;
    public int scale = 2;
    public Data(String n, String cP, Double lat, Double lon, String c, Float dis, Integer sp, String z, String s, String sN, String cY){
        names = n;
        cPoints = cP;
        latitude = lat;
        longitude = lon;
        code = c;
        distance = dis;
        spots = sp;
        zipcode = z;
        street = s;
        streetNumber = sN;
        city = cY;
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
    public Integer getSpots(){
        return spots;
    }
    public String getZipcode() {
        return zipcode;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getCity() {
        return city;
    }

    public Double getDistance(){
        return Math.round(distance * Math.pow(10, scale)) / Math.pow(10, scale);
    }


}

