package com.example.sid.marwadishaadi.Dashboard_Favourites;

/**
 * Created by pranay on 01-06-2017.
 */

public class FavouriteModel {
    private String name,location,highest_degree,imageurl;
    private int age;
    public FavouriteModel(String name, String location, String highest_degree, int age, String imageurl){
        this.name=name;
        this.location=location;
        this.highest_degree=highest_degree;
        this.age=age;
        this.imageurl=imageurl;
    }

    public int getAge() {
        return age;
    }

    public String getHighest_degree() {
        return highest_degree;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHighest_degree(String highest_degree) {
        this.highest_degree = highest_degree;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
