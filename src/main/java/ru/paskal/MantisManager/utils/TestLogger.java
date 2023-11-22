package ru.paskal.MantisManager.utils;

import org.springframework.stereotype.Component;

@Component
public class TestLogger {
  public static final String ANSI_RESET = "\033[0m";
  public static final String ANSI_GREEN = "\033[32m";

  public static void log(Object o) {
    System.out.println(ANSI_GREEN + o + ANSI_RESET);
  }

}
