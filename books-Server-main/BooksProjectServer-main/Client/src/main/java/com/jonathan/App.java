package com.jonathan;

import com.jonathan.dto.*;
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
                case "1" -> manageAuthor();
                case "2" -> manageGenre();
                case "3" -> managePublishing();
                case "4" -> managePersonalInformation();
                case "5" -> manageBookRead();
                case "6" -> manageBookPending();
            }

        } while (!command.equals("exit"));
    }

    private static void manageBookRead() throws IOException {
        var command = "";
        do {
            showBookReadMenu();
            command = readLine(in);

            switch (command) {
                case "1" -> {
                    try {
                        var books = restClient.getAll("/bookRead", BookReadDto[].class);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                case "2" -> {
                    var bookId = readLine(in);
                    try {
                        var book = restClient.get("/bookRead/" + bookId, BookReadDto.class);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        } while (!command.equals("exit"));
    }
    private static void managePersonalInformation() throws IOException {
        var command = "";
        do {
            showPersonalInformationMenu();
            command = readLine(in);

            switch (command) {
                case "1" -> {
                    try {
                        var personalInfos = restClient.getAll("/personalInformation", PersonalInformationDto[].class);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                case "2" -> {
                    var infoId = readLine(in);
                    try {
                        var personalInfo = restClient.get("/personalInformation/" + infoId, PersonalInformationDto.class);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }

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
                        var clients = restClient.getAll("genre", GenreDto[].class);
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
    private static void manageBookPending() throws IOException {
        var command = "";
        do {
            showBookPendingMenu();
            command = readLine(in);

            switch (command) {
                case "1" -> {
                    try {
                        var books = restClient.getAll("/bookPending", BookPendingDto[].class);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                case "2" -> {
                    var bookId = readLine(in);
                    try {
                        var book = restClient.get("/bookPending/" + bookId, BookPendingDto.class);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        } while (!command.equals("exit"));
    }
    private static void showMainMenu() {
        out.println("1. Author");
        out.println("2. Genre");
        out.println("3. Publishing");
        out.println("4. PersonalInformation");
        out.println("5. BookRead");
        out.println("6. BookPending");


    }
    private static void managePublishing() throws IOException {
        var command = "";
        do {
            showPublishingMenu();
            command = readLine(in);

            switch (command) {
                case "1" -> {
                    try {
                        var publishings = restClient.getAll("/publishing", PublishingDto[].class);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                case "2" -> {
                    var publishingId = readLine(in);
                    try {
                        var publishing = restClient.get("/publishing/" + publishingId, PublishingDto.class);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        } while (!command.equals("exit"));
    }
    private static void manageAuthor() throws IOException {
        var command = "";
        do {
            showAuthorMenu();
            command = readLine(in);

            switch (command) {
                case "1" -> {
                    try {
                        var authors = restClient.getAll("/author", AuthorDto[].class);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                case "2" -> {
                    var authorId = readLine(in);
                    try {
                        var author = restClient.get("/author/" + authorId, AuthorDto.class);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        } while (!command.equals("exit"));
    }
    private static void showAuthorMenu() {
        out.println("Author Management System:");
        out.println("1. Show all Authors");
        out.println("2. Get an Author");
        out.println("3. Create a new Author");
        out.println("4. Exit");
    }
    private static void showPublishingMenu() {
        out.println("Publishing Management System:");
        out.println("1. Show all Publishing");
        out.println("2. Get a Publishing");
        out.println("3. Create a new Publishing");
        out.println("4. Exit");
    }

    private static void showPersonalInformationMenu() {
        out.println("Personal Information Management System:");
        out.println("1. Show all Personal Information");
        out.println("2. Get Personal Information");
        out.println("3. Update Personal Information");
        out.println("4. Exit");
    }

    private static void showBookReadMenu() {
        out.println("Book Read Management System:");
        out.println("1. Show all Books Read");
        out.println("2. Get a Book Read");
        out.println("3. Mark a Book as Read");
        out.println("4. Exit");
    }

    private static void showBookPendingMenu() {
        out.println("Book Pending Management System:");
        out.println("1. Show all Books Pending");
        out.println("2. Get a Book Pending");
        out.println("3. Mark a Book as Pending");
        out.println("4. Exit");
    }
}
