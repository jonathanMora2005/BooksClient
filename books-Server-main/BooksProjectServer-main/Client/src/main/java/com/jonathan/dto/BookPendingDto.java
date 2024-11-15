package com.jonathan.dto;

import com.jonathan.mybooklist.models.PendingBook;

import java.time.LocalDate;

public class BookPendingDto implements PendingBook {

    private int idBookPending;      // Variable para almacenar el ID del libro pendiente
    private String name;            // Variable para almacenar el nombre del libro
    private LocalDate publicationDate;  // Variable para almacenar la fecha de publicación
    private int pages;              // Variable para almacenar el número de páginas
    private String description;     // Variable para almacenar la descripción del libro
    private int authorId;           // Variable para almacenar el ID del autor
    private int publishingId;       // Variable para almacenar el ID de la editorial
    private int genreCode;          // Variable para almacenar el código del género

    // Constructor vacío
    public BookPendingDto() {}

    // Implementación de los métodos de la interfaz PendingBook

    @Override
    public int getidBookPending() {
        return idBookPending;
    }

    @Override
    public void setid_bookPending(int idBookPending) {
        this.idBookPending = idBookPending;
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
    public LocalDate getpublicationDate() {
        return publicationDate;
    }

    @Override
    public void setpublicationDate(LocalDate publicationDate) {
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
