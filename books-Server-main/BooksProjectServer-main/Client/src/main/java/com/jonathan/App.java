package com.jonathan;

import com.jonathan.dto.GenreDto;
import com.jonathan.utils.Mappers;
import com.jonathan.utils.RestClient;
import com.jonathan.utils.RestClientImpl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class App {

    private static  final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static  final PrintStream out = new PrintStream(System.out);
    private static RestClient restClient = new RestClientImpl("localhost", 3000);


    public static void main(String[] args) throws IOException {
        var command = "";
        do {
            showMainMenu();
            command = readLine(in);

            switch (command) {
                case "2" -> manageGenre();
            }

        } while (!command.equals("exit"));
    }
    private static void manageGenre() throws IOException {
        var command = "";
        do {
            showGenreMenu();

            command = readLine(in);

            switch (command) {
                case "1" -> {
                    try {
                        var clients = restClient.getAll("/genre", GenreDto[].class);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                case "2" -> {
                    var courseId = readLine(in);
                    try {
                        var client = restClient.get("/genre/" + courseId, GenreDto.class);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                case "3" -> {
                    var course = new GenreDto();

                    course.setdescription(readLine(in));

                    try {
                        restClient.post("/genre", Mappers.get().writeValueAsString(course));
                    }catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                }
            }

        } while (!command.equals("exit"));
    }

    private static void showGenreMenu() {
        out.println("Genre Management System:");
        out.println("1. Show all Genre");
        out.println("2. Get");
        out.println("3. Update an Genre");
        out.println("4. Insert a new Genre");

        out.println("6. delete");
    }
    private static String readLine(BufferedReader in) {
        String command;
        try {
            command = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Error while reading the menu option", e);
        }
        return command;
    }
    private static void showMainMenu() {
        out.println("1. Author");
        out.println("2. Genre");
        out.println("3. Publishing");
        out.println("4. PersonalInformation");
        out.println("5. BookRead");
        out.println("6. BookPending");


    }
}
