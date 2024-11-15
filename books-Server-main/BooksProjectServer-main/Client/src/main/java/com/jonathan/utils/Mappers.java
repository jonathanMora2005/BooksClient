package com.jonathan.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.jonathan.dto.GenreDto;
import com.jonathan.mybooklist.models.Genre;

public class Mappers {
    private static final ObjectMapper mapper;

    static  {
        mapper = new ObjectMapper();
        mapper
                .registerModule(new JavaTimeModule()) // Registered to map LocalDate (add implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.18.0" to build.gradle.kts) )
                .registerModule(
                        new SimpleModule()
                                .addAbstractTypeMapping(Genre.class, GenreDto.class)
                )
                .registerModule(
                        new SimpleModule()
                                .addAbstractTypeMapping(Genre.class, GenreDto.class)
                ); // Registered to map the Genre deserialization
    }

    public static ObjectMapper get() {
        return mapper;
    }
}