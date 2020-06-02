package com.example.person;

public class Geo {

    private String Lat, Lng;

    public String getLat() {
        return Lat;
    }

    public void setLat(String lat) {
        Lat = lat;
    }

    public String getLng() {
        return Lng;
    }

    public void setLng(String lng) {
        Lng = lng;
    }

    public Geo(String lat, String lng) {
        Lat = lat;
        Lng = lng;
    }

    public Geo() {
    }
}
