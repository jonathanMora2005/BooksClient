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

            T returnValue = null;
            var response = rawHttp.parseResponse(socket.getInputStream()).eagerly();
            System.out.println("respuets:"+ response);

            if (!returnType.isAssignableFrom(Void.class) && response.getBody().isPresent() && response.getBody().get().toString().trim().length() > 0) {
                String responseBody = response.getBody().get().toString();
                returnValue = Mappers.get().readValue(responseBody, returnType);
            } else {
                System.out.println("La respuesta no contiene un cuerpo JSON.");
            }


            return returnValue;
        } catch (IOException e) {
            throw new Exception(e);
        }
    }
}