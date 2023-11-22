package ru.paskal.MantisManager.utils;

import org.springframework.stereotype.Component;

@Component
public class TestLogger {
  public static final String RESET = "\033[0m";
  public static final String GREEN = "\033[32m";
  public static final String YELLOW = "\033[33m";

  public static final String MAGENTA = "\033[35m";

  public static void log(Object o) {
    System.out.println(GREEN + "[LOG] " + RESET + MAGENTA + o + RESET);
  }

  public static void log(Object o, String who) {

    System.out.println(
        String.format(
            "%s[LOG]%s --- %s<%s>%s -> %s",
            GREEN, RESET, YELLOW, who, RESET, MAGENTA
        )
            + o + RESET
    );
  }

}
