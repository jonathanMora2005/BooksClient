package com.jonathan.dto;

import com.jonathan.mybooklist.models.Author;
import com.jonathan.mybooklist.models.PersonalInformation;

import java.sql.Date;
public class PersonalInformationDto implements PersonalInformation {

    private String DNI;           // Variable para almacenar el DNI
    private Author authorId;      // Variable para almacenar la referencia del autor
    private String nationality;   // Variable para almacenar la nacionalidad
    private Date dateOfBirth;     // Variable para almacenar la fecha de nacimiento
    private int phone;            // Variable para almacenar el número de teléfono
    private String address;       // Variable para almacenar la dirección

    // Constructor
    public PersonalInformationDto() {}

    // Implementaciones de los métodos de la interfaz

    @Override
    public String getDNI() {
        return DNI;
    }

    @Override
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public Author getauthorId() {
        return authorId;
    }

    @Override
    public void setAuthorId(Author authorId) {
        this.authorId = authorId;
    }

    @Override
    public String getNationality() {
        return nationality;
    }

    @Override
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public int getPhone() {
        return phone;
    }

    @Override
    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }
}