package tech.luigui.katas;

public class HumanReadableTime {
  public static String makeReadable(int totalSeconds) {
    int hours = Math.floorDiv(totalSeconds, 3600);
    int minutes = Math.floorDiv(totalSeconds % 3600, 60);
    int seconds = totalSeconds % 60;
    return String.format("%02d:%02d:%02d", hours, minutes, seconds);
  }
}
