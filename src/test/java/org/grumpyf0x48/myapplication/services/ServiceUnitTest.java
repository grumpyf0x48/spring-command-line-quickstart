package org.grumpyf0x48.myapplication.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ServiceUnitTest {

    @InjectMocks
    Service service;

    @Test
    @DisplayName("When service is called it returns hello")
    public void have_service_returning_hello() {
        String hello = service.hello();
        assertEquals("hello", hello);
    }
}