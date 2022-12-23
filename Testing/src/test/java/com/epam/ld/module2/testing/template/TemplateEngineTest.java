package com.epam.ld.module2.testing.template;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.epam.ld.module2.testing.entity.Client;
import com.epam.ld.module2.testing.exception.InsufficientDataException;
import com.epam.ld.module2.testing.meta.BusinessLogicTest;

@BusinessLogicTest
class TemplateEngineTest {

    private final TemplateEngine sut = new TemplateEngine();

    @ParameterizedTest
    @MethodSource("generateNonExceptionalTestCases")
    void shouldGenerateMessageWhenValidDataPassed(String expectedResult, Template template, Client client) {
        String actual = sut.generateMessage(template, client);

        assertThat(actual, is(expectedResult));
    }

    @Test
    void shouldThrowInsufficientDataExceptionWhenNotAllSubsPresent() {
        Template template = new Template("Template 1 has #{valueSub}", Collections.emptyMap());
        Client client = new Client("Address1");

        assertThrows(InsufficientDataException.class, () -> sut.generateMessage(template, client));
    }

    private static Stream<Arguments> generateNonExceptionalTestCases() {
        return Stream.of(Arguments.of("Template 1 has SubstitutedValue. Sent to Address1", new Template("Template 1 has #{valueSub}",
                        Map.of("valueSub", "SubstitutedValue")), new Client("Address1")),
                Arguments.of("Template 2 has SubstitutedValue1 and #{tag}. Sent to Address2", new Template("Template 2 has #{valueSub} and #{valueSub2}",
                        Map.of("valueSub", "SubstitutedValue1", "valueSub2", "#{tag}")), new Client("Address2")),
                Arguments.of("Template 1 has SubstitutedValue. Sent to Address3", new Template("Template 1 has #{valueSub}",
                        Map.of("valueSub", "SubstitutedValue", "valueSub2", "WillNotBePresent")), new Client("Address3")));
    }

}
