package com.jonathan.dto;

import com.jonathan.mybooklist.models.Genre;
import com.jonathan.mybooklist.models.ReadBook;

import java.sql.Date;

public class BookReadDto implements ReadBook {

    private int idBookRead;        // Variable para almacenar el ID del libro leído
    private String name;           // Variable para almacenar el nombre del libro
    private Date publicationDate;  // Variable para almacenar la fecha de publicación
    private int pages;             // Variable para almacenar el número de páginas
    private String description;    // Variable para almacenar la descripción del libro
    private int authorId;          // Variable para almacenar el ID del autor
    private int publishingId;      // Variable para almacenar el ID de la editorial
    private int genreCode;         // Variable para almacenar el código del género

    // Constructor vacío
    public BookReadDto() {}

    // Implementación de los métodos de la interfaz ReadBook

    @Override
    public int getidBookRead() {
        return idBookRead;
    }

    @Override
    public void setidBookRead(int idBookRead) {
        this.idBookRead = idBookRead;
    }

    @Override
    public String getname() {
        return name;
    }

    @Override
    public void setname(String name) {
        this.name = name;
    }

    @Override
    public Date getpublicationDate() {
        return publicationDate;
    }

    @Override
    public void setpublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public int getpages() {
        return pages;
    }

    @Override
    public void setpages(int pages) {
        this.pages = pages;
    }

    @Override
    public String getdescription() {
        return description;
    }

    @Override
    public void setdescription(String description) {
        this.description = description;
    }

    @Override
    public int getauthorId() {
        return authorId;
    }

    @Override
    public void setauthorId(int authorId) {
        this.authorId = authorId;
    }

    @Override
    public int getpublishingId() {
        return publishingId;
    }

    @Override
    public void publishingId(int publishingId) {
        this.publishingId = publishingId;
    }

    @Override
    public int getgenreCode() {
        return genreCode;
    }

    @Override
    public void setgenreCode(int genreCode) {
        this.genreCode = genreCode;
    }
}
