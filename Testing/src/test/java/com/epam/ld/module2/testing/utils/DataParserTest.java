package com.epam.ld.module2.testing.utils;

import org.junit.jupiter.api.Test;

import com.epam.ld.module2.testing.entity.Client;
import com.epam.ld.module2.testing.template.Template;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Map;

class DataParserTest {

    private static final String DATA = "Hello! I wanted to share #{item} with you\n" +
            "item=this\n" +
            "Client@mail.ru";

    private final DataParser sut = new DataParser();

    @Test
    void shouldParseTemplate() {
        Template expected = new Template("Hello! I wanted to share #{item} with you", Map.of("item", "this"));

        Template actual = sut.parseData(Template.class, DATA);

        assertThat(actual, is(expected));
    }

    @Test
    void shouldParseClient() {
        Client expected = new Client("Client@mail.ru");

        Client actual = sut.parseData(Client.class, DATA);

        assertThat(actual, is(expected));
    }

}
