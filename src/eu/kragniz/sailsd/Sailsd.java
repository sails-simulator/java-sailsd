package eu.kragniz.sailsd;

import java.io.IOException;
import java.net.Socket;

public class Sailsd {
    private String hostname;
    private int port;
    Socket sailsdSocket;

    public Sailsd(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public Socket getConnection() throws IOException {
        return new Socket(this.hostname, this.port);
    }
}
