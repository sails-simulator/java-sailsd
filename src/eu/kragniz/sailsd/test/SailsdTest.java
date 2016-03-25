package eu.kragniz.sailsd.test;

import eu.kragniz.sailsd.Sailsd;
import org.junit.*;
import static org.junit.Assert.*;

public class SailsdTest {

    @Test
    public void testConstructor() {
        Sailsd sailsd = new Sailsd("localhost", 3333);
    }

    @Test
    public void testConnect() throws Exception {
        Sailsd sailsd = new Sailsd("localhost", 3333);
        sailsd.connect();
    }
}