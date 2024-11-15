package com.jonathan.dto;

import com.jonathan.mybooklist.models.Genre;
import com.jonathan.mybooklist.models.PendingBook;
import com.jonathan.mybooklist.models.ReadBook;

import java.util.Set;

public class GenreDto implements Genre {
    private int id;
    private String name;  // Nueva propiedad para "name"

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setid(int id) {
        this.id = id;
    }

    @Override
    public String getdescription() {
        return name ;
    }

    @Override
    public void setdescription(String description) {
        this.name  = description;
    }

    @Override
    public Set<ReadBook> getReadBook() {
        return Set.of();
    }

    @Override
    public void setReadBook(Set<ReadBook> readBook) {

    }

    @Override
    public Set<PendingBook> getPendingBook() {
        return Set.of();
    }

    @Override
    public void setPendingBook(Set<PendingBook> pendingBook) {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
