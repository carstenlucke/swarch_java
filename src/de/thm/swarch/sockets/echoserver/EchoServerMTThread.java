package de.thm.swarch.sockets.echoserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoServerMTThread extends Thread {

    private Socket clientSocket;

    EchoServerMTThread(Socket s) {
        super("EchoServerMultiThread");
        this.clientSocket = s;
    }

    public void run() {

        // TODO: Ihr Echo-Serverthread Code hier ...
    }
}