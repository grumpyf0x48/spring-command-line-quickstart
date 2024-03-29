package org.grumpyf0x48.spring_command_line_quickstart;

import lombok.RequiredArgsConstructor;
import org.grumpyf0x48.spring_command_line_quickstart.commands.Command;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

@Component
@RequiredArgsConstructor
public class CommandLineHandler implements CommandLineRunner, ExitCodeGenerator {

    private final Command command;

    private int exitCode;

    @Override
    public void run(String... args) {
        exitCode = new CommandLine(command).execute(args);
    }

    @Override
    public int getExitCode() {
        return exitCode;
    }
}
