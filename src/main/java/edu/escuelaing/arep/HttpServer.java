package edu.escuelaing.arep;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class HttpServer {

    public static void start(int port) throws IOException {

        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Server running on http://localhost:" + port);

        while(true) {

            Socket clientSocket = serverSocket.accept();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream())
            );

            OutputStream out = clientSocket.getOutputStream();

            String requestLine = in.readLine();

            if(requestLine == null) continue;

            String[] parts = requestLine.split(" ");

            String pathQuery = parts[1];

            String path = pathQuery;
            String query = null;

            if(pathQuery.contains("?")) {

                String[] pq = pathQuery.split("\\?");

                path = pq[0];
                query = pq[1];
            }

            Request req = new Request(query);
            Response res = new Response();

            Map<String, Route> routes = MicroFramework.getRoutes();

            if(routes.containsKey(path)) {

                String result = routes.get(path).handle(req, res);

                String response =
                        "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: " + res.getType() + "\r\n\r\n" +
                        result;

                out.write(response.getBytes());

            } else {

                String filePath =
                        "src/main/resources" +
                        MicroFramework.getStaticFolder() +
                        path;

                File file = new File(filePath);

                if(file.exists()) {

                    byte[] fileBytes = Files.readAllBytes(Paths.get(filePath));

                    String header =
                            "HTTP/1.1 200 OK\r\n\r\n";

                    out.write(header.getBytes());
                    out.write(fileBytes);

                } else {

                    String response =
                            "HTTP/1.1 404 Not Found\r\n\r\nNot Found";

                    out.write(response.getBytes());
                }

            }

            out.close();
            in.close();
            clientSocket.close();
        }

    }

}