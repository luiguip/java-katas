package tech.luigui.katas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class HumanReadableTimeTest {
  @ParameterizedTest
  @CsvSource({"59,00:00:59", "3599,00:59:59", "7299,02:01:39"})
  void makeReadable_ShouldReturnStringTime(String input, String expected) {
    int s = Integer.parseInt(input);
    assertEquals(expected, HumanReadableTime.makeReadable(s));
  }
}
