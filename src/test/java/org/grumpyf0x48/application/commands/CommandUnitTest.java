package org.grumpyf0x48.application.commands;

import org.grumpyf0x48.application.services.Service;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CommandUnitTest {

    @InjectMocks
    Command command;

    @Mock
    Service service;

    @Test
    @DisplayName("When command is called then service is called")
    void have_command_calling_service() {
        when(service.hello()).thenReturn("hello from mock");
        command.call();
        verify(service).hello();
    }
}
