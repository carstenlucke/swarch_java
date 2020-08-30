package de.thm.swarch.ws.helloworld.service;

//Endpoint publisher
public class HelloStarter {

    public static final String WS_HOST = "localhost";
    public static final String WS_PORT = "9999";

    public static void main(String[] args) {
        String url = "http://" + WS_HOST + ":" + WS_PORT + "/helloworld";

        // TODO: Endpoint.publish(...);
        System.out.println("Starte HelloWorld: " + url + ". WSDL siehe " + url + "?wsdl");
    }

}
