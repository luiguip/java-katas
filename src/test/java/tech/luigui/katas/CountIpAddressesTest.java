package tech.luigui.katas;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountIpAddressesTest {

    @Test
    void ipsBetweenTest() {
        assertEquals(50, CountIpAddresses.ipsBetween("10.0.0.0", "10.0.0.50"));
        assertEquals(246, CountIpAddresses.ipsBetween("20.0.0.10", "20.0.1.0"));
    }

    @Test
    void numberOfIpsString() {
        assertEquals(50, CountIpAddresses.numberOfIps("0.0.0.50"));
        assertEquals(256, CountIpAddresses.numberOfIps("0.0.1.0"));
        assertEquals((long) Math.pow(256, 2), CountIpAddresses.numberOfIps("0.1.0.0"));
        assertEquals((long) Math.pow(256, 3), CountIpAddresses.numberOfIps("1.0.0.0"));
    }

    @Test
    void numberOfIpsSplittedTest() {
        assertEquals(50, CountIpAddresses.numberOfIps(LongStream.of(50L, 0L, 0L, 0L).boxed().toArray(Long[]::new)));
        assertEquals(256, CountIpAddresses.numberOfIps(LongStream.of(0L, 1L, 0L, 0L).boxed().toArray(Long[]::new)));
        assertEquals((long) Math.pow(256, 2), CountIpAddresses.numberOfIps(LongStream.of(0L, 0L, 1L, 0L).boxed().toArray(Long[]::new)));
        assertEquals((long) Math.pow(256, 3), CountIpAddresses.numberOfIps(LongStream.of(0L, 0L, 0L, 1L).boxed().toArray(Long[]::new)));
    }

}
