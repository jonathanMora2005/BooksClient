package com.jonathan.utils;
import rawhttp.core.*;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


public class RestClientImpl implements RestClient {
    private final int port;
    private final String host;

    public RestClientImpl(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public <T> T get(String path, Class<T> returnType) throws Exception {
        return execRequest("GET", path, null, returnType);
    }

    @Override
    public <T> T[] getAll(String path, Class<T[]> returnType) throws Exception {
        return execRequest("GET", path + "/0", null, returnType);
    }

    @Override
    public void post(String path, String body) throws Exception {
        execRequest("POST", path, body, Void.class);
    }

    @Override
    public void put(String path, String body) throws Exception {
        execRequest("PUT", path, body, Void.class);
    }

    @Override
    public void delete(String path, String body) throws Exception {
        execRequest("DELETE", path, body, Void.class);
    }

    protected <T> T execRequest(String method, String path, String body, Class<T> returnType) throws Exception {
        var rawHttp = new RawHttp();

        // Initialize socket and ensure it's closed after use
        try (var socket = new Socket(host, port)) {
            if (body == null) {
                body = "";
            }

            // Create and write the HTTP request
            var request = rawHttp.parseRequest(
                    method + " " + String.format("http://%s:%d/%s", host, port, path) + " HTTP/1.1\r\n" +
                            "Host: " + host + "\r\n" +
                            "User-Agent: RawHTTP\r\n" +
                            "Content-Length: " + body.length() + "\r\n" +
                            "Content-Type: application/json\r\n" +
                            "Accept: application/json\r\n" +
                            "\r\n" +
                            body
            );

            // Send request
            request.writeTo(socket.getOutputStream());

            // Parse the response
            try {
                var response = rawHttp.parseResponse(socket.getInputStream()).eagerly();
                // Check for response body and deserialize if necessary
                if (response.getBody().isPresent()) {
                    String responseBody = new String(response.getBody().get().asRawBytes());
                    System.out.println(responseBody);
                    try {
                        return Mappers.get().readValue(responseBody, returnType);
                    } catch (Exception e) {
                        throw new RuntimeException("Error al deserializar la respuesta: " + responseBody, e);
                    }
                }
            } catch (Exception e) {
                System.err.println("Ocurrió un error procesando la respuesta: " + e.getMessage());
                e.printStackTrace();
                return null;
            }

            // Return null for Void type
            return null;
        } catch (IOException e) {
            // Log or wrap the exception with additional context
            throw new RuntimeException("Error executing HTTP request: " + method + " " + path);
        }
    }
}
