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
        return execRequest("GET", path+"/0", null, returnType);
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

    protected <T> T execRequest(String method, String path, String body, Class<T> returnType) throws  Exception {
        var rawHttp = new RawHttp();
        try (var socket = new Socket(host, port)) {
           /* var request = new RawHttpRequest(
                    new RequestLine(
                            "GET",
                            new URI(String.format("http://%s:%d/%s", host, port, path)),
                            HttpVersion.HTTP_1_1
                    ),
                    RawHttpHeaders.newBuilder()
                            .with("User-Agent", "RestClient/1.0")
                            .with("Host", host)
                            .build(),
                    null,
                    InetAddress.getByName(host)
            );*/

            if (body == null) {
                body = "";
            }

            var request = rawHttp.parseRequest(
                    method + " " + String.format("http://%s:%d/%s", host, port, path) + " HTTP/1.1\r\n" +
                            "Host: " + host + "\r\n" +
                            "User-Agent: RawHTTP\r\n" +
                            "Content-Length: " + body.length()+ "\r\n" +
                            "Content-Type: application/json\r\n" +
                            "Accept: application/json\r\n" +
                            "\r\n" +
                            body
            );

            request.writeTo(socket.getOutputStream());
            System.out.println(request);
            T returnValue = null;
            System.out.println("1");
            try {
                var response = rawHttp.parseResponse(socket.getInputStream());

                if (response != null) {
                    System.out.println("Respuesta recibida: " + response);
                    int statusCode = response.getStatusCode();
                    System.out.println("Código de estado: " + statusCode);

                    if (statusCode == 204) {
                        System.out.println("La respuesta es 'No Content' (204). No hay cuerpo.");
                        return null; // O maneja según corresponda
                    }

                    if (response.getBody().isPresent()) {
                        String responseBody = response.getBody().get().toString();
                        System.out.println("Cuerpo de la respuesta: " + responseBody);
                        returnValue = Mappers.get().readValue(responseBody, returnType);
                    } else {
                        System.out.println("La respuesta no contiene cuerpo.");
                    }
                } else {
                    System.out.println("No se recibió respuesta válida.");
                }
            } catch (Exception e) {
                System.err.println("Error al procesar la respuesta: " + e.getMessage());
                e.printStackTrace();
                // Maneja el error de alguna manera, si es necesario.
            }

            return returnValue;
        } catch (IOException e) {
            throw new Exception(e);
        }
    }
}