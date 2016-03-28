package eu.kragniz.sailsd;

import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;
import static java.lang.System.arraycopy;

public class Sailsd {
    private String hostname;
    private int port;

    private static Gson gson = new Gson();

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
        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream())
        );

        byte[] messageBytes = stringToNullBytes(message);
        out.write(messageBytes, 0, messageBytes.length);

        String returnValue = in.readLine();
        connection.close();
        return returnValue;
    }

    private SailsdAPIResponse getResponse(String message) throws IOException {
        String output = sendMessageString(message);
        return gson.fromJson(output, SailsdAPIResponse.class);
    }

    public double getVersion() throws IOException {
        SailsdAPIResponse resp = getResponse("{\"request\": [\"version\"]}");

        return resp.version;
    }
}
