package org.grumpyf0x48.applicationName.commands;

import lombok.RequiredArgsConstructor;
import org.grumpyf0x48.applicationName.services.Service;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@Component
@RequiredArgsConstructor
@CommandLine.Command
public class Command implements Callable<Integer> {

    private final Service service;

    @Override
    public Integer call() {
        System.out.printf("%s from %s called%n", service.hello(), this.getClass().getName());
        return 0;
    }
}
