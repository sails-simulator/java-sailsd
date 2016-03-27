package eu.kragniz.sailsd.test;

import eu.kragniz.sailsd.Sailsd;
import org.junit.*;
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
        sailsd.sendMessageString("this should fail");
    }
}