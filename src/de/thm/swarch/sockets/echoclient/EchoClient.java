package de.thm.swarch.sockets.echoclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.err.println(
                    "Usage: java de.thm.swarch.sockets.EchoClient <host name> <port number>");
            System.exit(1);
        }

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        // TODO: Ihr Client-Code hier ...
    }

}
