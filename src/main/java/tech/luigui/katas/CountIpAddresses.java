package tech.luigui.katas;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class CountIpAddresses {

    private final static long DOTTED_ADDRESS = 256;

    public static long ipsBetween(String start, String end) {
        return numberOfIps(end) - numberOfIps(start);
    }

    public static long numberOfIps(String ip) {
        var ipSplittedList = Arrays.stream(ip.split("\\."))
                .map(Long::valueOf)
                .collect(Collectors.toList());
        Collections.reverse(ipSplittedList);
        var ipSplitted = Arrays.copyOf(ipSplittedList.toArray(), ipSplittedList.size(), Long[].class);
        return numberOfIps(ipSplitted);
    }

    public static long numberOfIps(Long[] ipSplitted) {
        return LongStream.range(0,4)
                .map(i -> ipSplitted[(int) i] * (long) Math.pow(DOTTED_ADDRESS, i))
                .sum();
    }
}
