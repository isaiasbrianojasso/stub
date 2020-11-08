package test.java.org.example;


import main.java.org.example.EchoService;
import org.junit.jupiter.api.Test;
import test.java.org.example.stubs.TestInputStream;
import test.java.org.example.stubs.TestOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.*;


public class EchoServiceTest {

    @Test
    public void givenValidRequestAndResponse_whenEcho_thenTrueIsResponded() throws IOException
    {
        //Given
        EchoService echoService = new EchoService();
        String ip = "10.10.0.15";
        int port = 9000;
        String request = "Hello World!";
        TestOutputStream outputStream = new TestOutputStream();
		InputStream inputStream = new TestInputStream(request);
        //When
		boolean response = echoService.sendEchoMessage(request, outputStream, inputStream);
        //Then
        String messageSent = outputStream.getMessageSent();
        assertEquals(request, messageSent);
        assertTrue(response);
    }

    @Test
    public void givenValidRequestAndWrongResponse_whenEcho_thenFalseIsResponded() throws IOException
    {
        //Given
        EchoService echoService = new EchoService();
        String ip = "10.10.0.15";
        int port = 9000;
        String request = "Hello World!";
        TestOutputStream outputStream = new TestOutputStream();
		InputStream inputStream = new TestInputStream("Otra cosa");
        //When
		boolean response = echoService.sendEchoMessage(request, outputStream, inputStream);
        //Then
        String messageSent = outputStream.getMessageSent();
        assertEquals(request, messageSent);
        assertFalse(response);
    }
}

