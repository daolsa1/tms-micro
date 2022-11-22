package com.johndeere.tms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.SpringVersion;

@Slf4j
@SpringBootApplication(scanBasePackageClasses = {Application.class})
@SuppressWarnings({"PMD.UseUtilityClass", "PMD.AvoidCatchingGenericException"})
@ComponentScan(basePackages = {"com.johndeere"})
public class Application {

    /**
     * Main method.
     *
     * @param args arguments passed to main method
     */

    public static void main(String[] args) {
        log.info(SpringVersion.getVersion());
        SpringApplication.run(Application.class, args);
    }
}
