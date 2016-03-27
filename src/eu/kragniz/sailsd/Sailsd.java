package eu.kragniz.sailsd;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import static java.lang.System.arraycopy;

public class Sailsd {
    private String hostname;
    private int port;

    public Sailsd(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public Socket getConnection() throws IOException {
        return new Socket(this.hostname, this.port);
    }

    private byte[] stringToNullBytes(String input) throws UnsupportedEncodingException {
        byte[] stringBytes = input.getBytes("ISO-8859-1");
        byte[] nullBytes = new byte[stringBytes.length+1];
        arraycopy(stringBytes, 0, nullBytes, 0, stringBytes.length);
        return nullBytes;
    }

    public String sendMessageString(String message) throws IOException {
        Socket connection = getConnection();
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        byte[] messageBytes = stringToNullBytes(message);
        out.write(messageBytes, 0, messageBytes.length);
        connection.close();

        return "";
    }
}
