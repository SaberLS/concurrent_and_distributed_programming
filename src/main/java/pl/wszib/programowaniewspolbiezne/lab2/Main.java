package pl.wszib.programowaniewspolbiezne.lab2;

import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    final int RUNS = 100_000_000;
    final Map<Integer, Integer> histogram = new HashMap<>();
    final int races = 100;

    for (int i = 0; i < races; i++) {
      System.out.println(i + "/" + races);

      Race race = new Race(RUNS);

      int result = race.start();

      System.out.println(result);
      histogram.put(result, histogram.getOrDefault(result, 0) + 1);
    }

    System.out.println("\n=== Histogram końcowych wartości licznika po " + races +
        " uruchomieniach ===");
    histogram.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByKey())
        .forEach(entry -> System.out.println(String.format("wartość %d: %d razy",
            entry.getKey(), entry.getValue())));
  }
}
