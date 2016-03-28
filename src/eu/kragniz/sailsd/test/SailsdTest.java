package eu.kragniz.sailsd.test;

import eu.kragniz.sailsd.Sailsd;
import org.junit.*;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Note: these tests require sailsd to be running and listening on localhost:3333
 */
public class SailsdTest {

    @Test
    public void testConstructor() {
        Sailsd sailsd = new Sailsd("localhost", 3333);
    }

    @Test
    public void testConnection() throws Exception {
        Sailsd sailsd = new Sailsd("localhost", 3333);
        sailsd.getConnection();
    }

    @Test
    public void testSendMessageString() throws Exception {
        Sailsd sailsd = new Sailsd("localhost", 3333);
        String v = sailsd.sendMessageString("{\"request\": [\"version\"]}");
        assertEquals("{\"version\": \"1.0\"}", v);
    }

    @Test
    public void testGetVersion() throws IOException {
        Sailsd sailsd = new Sailsd("localhost", 3333);
        double version = sailsd.getVersion();
        assertEquals(1.0, version, 0.01);
    }
}