package org.grumpyf0x48.spring_command_line_quickstart.commands;

import lombok.RequiredArgsConstructor;
import org.grumpyf0x48.spring_command_line_quickstart.services.Service;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@Component
@RequiredArgsConstructor
@CommandLine.Command(name = "Command", version = "0.1-SNAPSHOT", mixinStandardHelpOptions = true)
public class Command implements Callable<Integer> {

    private final Service service;

    @Override
    public Integer call() {
        System.out.printf("%s from %s called%n", service.hello(), this.getClass().getName());
        return 0;
    }
}
