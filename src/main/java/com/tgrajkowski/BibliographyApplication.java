package com.tgrajkowski;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliographyApplication {
    @Value("${info.company.name}")
    private static String myString;

    public static void main(String[] args) {
        System.out.println("checkoing is it really working...: " + myString);
        SpringApplication.run(BibliographyApplication.class, args);
    }
}

