package de.thm.swarch.sockets.echoserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerMT {


    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Usage: java de.thm.swarch.sockets.echoserver.EchoServerMT <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);
        boolean listening = true;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (listening) {
                Socket s = serverSocket.accept();
                new EchoServerMTThread(s).start();
                System.out.println("[INFO] Accepted connection from " + s.getRemoteSocketAddress());
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
    }

}