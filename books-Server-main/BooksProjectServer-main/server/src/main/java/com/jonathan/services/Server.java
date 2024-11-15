package com.jonathan.services;

import rawhttp.core.RawHttp;
import rawhttp.core.RawHttpOptions;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static  final int PORT = 3000;
    private boolean SHUTDOWN_SERVER;
    private  RequestRouterImpl router;

    public Server(RequestRouterImpl router) {
        this.router = router;
    }

    public  void start() throws IOException {
        try (var serverSocket = new ServerSocket(PORT)) {

            while (true) {
                try (var clientSocket = serverSocket.accept()) {
                    var rawHttp = new RawHttp(RawHttpOptions.newBuilder().doNotInsertHostHeaderIfMissing().build());
                    var request = rawHttp.parseRequest(clientSocket.getInputStream());
                    var response = router.execRequest(request);

                    response.writeTo(clientSocket.getOutputStream());
                }
            }
        }
    }
}
