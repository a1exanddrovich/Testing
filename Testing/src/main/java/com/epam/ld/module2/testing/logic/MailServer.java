package com.epam.ld.module2.testing.logic;

import java.util.Date;

/**
 * Mail server class.
 */
public class MailServer {

    /**
     * Send notification.
     *
     * @param addresses  the addresses
     * @param messageContent the message content
     */
    public void send(String addresses, String messageContent) {
        System.out.println("Message: " + messageContent + "\nWas sent to: " + addresses + "\nWas sent at: " + new Date(System.currentTimeMillis()));
    }
}
