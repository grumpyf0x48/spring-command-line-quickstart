package org.grumpyf0x48.application;

import org.grumpyf0x48.application.commands.Command;
import org.grumpyf0x48.application.services.Service;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ApplicationIntegrationTest {

    @Autowired
    Command command;

    @Autowired
    Service service;

    @Test
    @DisplayName("When application starts command is instantiated and functional and its dependencies are resolved")
    void have_command_and_dependencies_instantiated_at_startup() {
        int exitCode = command.call();
        assertEquals(0, exitCode);
    }

    @Test
    @DisplayName("When application starts service is instantiated and functional")
    void have_service_instantiated_at_startup() {
        String hello = service.hello();
        assertEquals("hello", hello);
    }
}
