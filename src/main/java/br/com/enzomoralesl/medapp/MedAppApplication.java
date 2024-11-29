package br.com.enzomoralesl.medapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import java.util.Arrays;


@SpringBootApplication
@ComponentScan(basePackages = "br.com.enzomoralesl")
public class MedAppApplication implements CommandLineRunner {

    private static final Logger LOGGER_TECNICO = LoggerFactory.getLogger(MedAppApplication.class);

    @Autowired
    private Environment environment;


    public static void main(String[] args) {
        SpringApplication.run(MedAppApplication.class, args);
    }
    @Override
    public void run(String... args) {
        if (isLocalProfile()) {
            LOGGER_TECNICO.info("Local Profile ativo...");
        }
    }

    private boolean isLocalProfile() {
        return Arrays.stream(environment.getActiveProfiles()).anyMatch(
                env -> (env.equalsIgnoreCase("local")));
    }

}
