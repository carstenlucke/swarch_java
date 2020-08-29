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

        try (
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {
            String inputLine;

            while ((inputLine = in.readLine()) != null) {

                out.println(inputLine);

                if (inputLine.equals("Bye.")) {
                    break;
                }
            }
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}