package de.thm.swarch.sockets.echoserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Usage: java de.thm.swarch.sockets.echoserver.EchoServer <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);

        try (
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))

        ) {
            System.out.println("[INFO] Client connected from " + clientSocket.getRemoteSocketAddress());
            String inputLine;

            while ((inputLine = in.readLine()) != null) {

                out.println(inputLine);

                if (inputLine.equals("Bye.")) {
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }

    }
}