package test.java.org.example.stubs;

import java.io.IOException;
import java.io.OutputStream;

public class TestOutputStream extends OutputStream{

    private String messageSent;

    @Override
    public void write(int b) throws IOException {
        // TODO Auto-generated method stub

    }

    @Override
    public void write(byte[] b) throws IOException {
        messageSent = new String(b);
    }

    public String getMessageSent(){
        return messageSent;
    }
}
