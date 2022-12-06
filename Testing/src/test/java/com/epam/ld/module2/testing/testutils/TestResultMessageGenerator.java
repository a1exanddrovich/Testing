package com.epam.ld.module2.testing.testutils;

import org.junit.jupiter.api.extension.ExtensionContext;

public class TestResultMessageGenerator {

    public String generateResultMessage(ExtensionContext context) {
        return context.getDisplayName() + " has the following tags " + context.getTags() +
                ". During execution throws exceptions: " + context.getExecutionException().isPresent() +
                ". Executed in " + context.getExecutionMode() + " mode\n";
    }

}
