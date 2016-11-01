
import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.classic.filter.ThresholdFilter
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.FileAppender

import static ch.qos.logback.classic.Level.ALL
import static ch.qos.logback.classic.Level.INFO
import static ch.qos.logback.classic.Level.WARN

def byDayTime = timestamp("yyyy-MM-dd'T'HH_mm_ss")
def byDay = timestamp("yyyy-MM-dd")

def pattern_simple = "%msg%n"
def pattern_default = "%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"
def pattern_ISO8601 = "%d{yyyy-MM-dd'T'HH:mm:ss.SSSXX} [%thread] %-5level %logger{36} - %msg%n"
def pattern_ISO8601_builtin = "%date{ISO8601} [%thread] %-5level %logger{36} - %msg%n"

def log_file
def err_file
def rName = System.getProperty("R_NAME", "")

if ("${rName}".length() > 0) {
  log_file = "Oh.Hello.${rName}.out.${byDay}.log"
  err_file = "Oh.Hello.${rName}.err.${byDay}.log"
}
else {
  log_file = "Oh.Hello.out.${byDay}.log"
  err_file = "Oh.Hello.err.${byDay}.log"
}

appender("FILEOUT", FileAppender) {
  file = "logs/${log_file}"
  append = true
  encoder(PatternLayoutEncoder) {
    pattern = "${pattern_ISO8601}"
  }
}

appender("FILEERR", FileAppender) {
  file = "logs/${err_file}"
  filter(ThresholdFilter) {
    level = WARN
  }
  append = true
  encoder(PatternLayoutEncoder) {
    pattern = "${pattern_ISO8601}"
  }
}

appender("STDOUT", ConsoleAppender) {
  filter(ThresholdFilter) {
    level = INFO
  }
  encoder(PatternLayoutEncoder) {
    pattern = "${pattern_default}"
  }
}

root(ALL, ["FILEOUT", "FILEERR", "STDOUT"])
