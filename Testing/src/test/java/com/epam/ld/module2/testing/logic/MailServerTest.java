package com.epam.ld.module2.testing.logic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import org.junit.jupiter.api.Test;

class MailServerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private final MailServer sut = new MailServer();

    @Test
    void shouldPrintOutMessage() {
        System.setOut(new PrintStream(outContent));
        String date = new Date(System.currentTimeMillis()).toString();
        sut.send("Alex322", "Hello, how are u?");
        assertThat(outContent.toString(), is("Message: Hello, how are u?\nWas sent to: Alex322\nWas sent at: " + date + "\r\n"));
    }


}
