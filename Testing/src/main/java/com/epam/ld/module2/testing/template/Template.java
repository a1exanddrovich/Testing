package com.epam.ld.module2.testing.template;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Map;

/**
 * The type Template.
 */
@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Template {

    private String template;
    private Map<String, String> values;

}
