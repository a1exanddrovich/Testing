package com.epam.ld.module2.testing.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

/**
 * The type Client.
 */
@AllArgsConstructor
@EqualsAndHashCode
public class Client {
    private String addresses;

    /**
     * Gets addresses.
     *
     * @return the addresses
     */
    public String getAddresses() {
        return addresses;
    }

    /**
     * Sets addresses.
     *
     * @param addresses the addresses
     */
    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }
}
