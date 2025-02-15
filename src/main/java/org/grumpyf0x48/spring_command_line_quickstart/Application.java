package org.grumpyf0x48.spring_command_line_quickstart;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.setLogStartupInfo(false);

        ConfigurableApplicationContext applicationContext = springApplication.run(args);

        int exitCode = SpringApplication.exit(applicationContext);
        System.exit(exitCode);
    }
}
