package org.author.labauthor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.JavaVersion;
import org.springframework.boot.system.SystemProperties;

@SpringBootApplication
public class LabAuthorApplication {

    public static void main(String[] args) {

        SpringApplication.run(LabAuthorApplication.class, args);

        System.out.println(SpringBootVersion.getVersion());
        System.out.println(JavaVersion.getJavaVersion());

    }


}
