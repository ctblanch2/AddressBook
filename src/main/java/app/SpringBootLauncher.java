package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by cameronblanchard on 2/2/2017.
 */
@SpringBootApplication
@EnableAutoConfiguration
public class SpringBootLauncher {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLauncher.class, args);
    }
}
