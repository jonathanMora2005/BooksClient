package com.jonathan.dto;

import com.jonathan.mybooklist.models.Publishing;

public class PublishingDto implements Publishing {
    private int id;
    private String nom;
    private String email;
    private String country;
    @Override
    public int getpublishingid() {
        return id;
    }

    @Override
    public void setpublishingid(int publishing) {
        id = publishing;
    }

    @Override
    public String getname() {
        return nom;
    }

    @Override
    public void setname(String name) {
            nom = name;
    }

    @Override
    public String getemail() {
        return email;
    }

    @Override
    public void setemail(String email) {
        this.email = email;
    }

    @Override
    public String getcountry() {
        return country;
    }


    @Override
    public void setcountry(String country) {
        this.country = country;

    }
}
