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

        // TODO: Ihr Server-Code hier

    }
}