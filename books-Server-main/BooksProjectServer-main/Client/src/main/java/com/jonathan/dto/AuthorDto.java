package com.jonathan.dto;

import com.jonathan.mybooklist.models.Author;

public class AuthorDto implements Author {
    private int id;
    private String nom;
    private String suname;
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getnom() {
        return nom;
    }

    @Override
    public void setnom(String nom) {
        this.nom = nom;
    }

    @Override
    public String getsurname() {
        return suname;
    }

    @Override
    public void setsurname(String surname) {
        this.suname = surname;
    }
}
