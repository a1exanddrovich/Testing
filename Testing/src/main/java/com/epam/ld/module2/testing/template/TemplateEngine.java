package com.epam.ld.module2.testing.template;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.ld.module2.testing.entity.Client;
import com.epam.ld.module2.testing.exception.InsufficientDataException;

/**
 * The type Template engine.
 */
public class TemplateEngine {
    /**
     * Generate message string.
     *
     * @param template the template
     * @param client   the client
     * @return the string
     */
    public String generateMessage(Template template, Client client) {
        String rawTemplate = template.getTemplate();
        Map<String, String> values = preprocessValues(template.getValues());

        StringBuilder generatedMessage = new StringBuilder();

        Pattern pattern = Pattern.compile("(\\#\\{.+?})");
        Matcher matcher = pattern.matcher(rawTemplate);
        int i = 0;
        while (matcher.find()) {
            String group = matcher.group(1);
            if (!values.containsKey(group)) {
                throw new InsufficientDataException("There no value for " + group + " present");
            }
            String replacement = values.get(group);
            generatedMessage.append(rawTemplate, i, matcher.start());
            generatedMessage.append(replacement);
            i = matcher.end();
        }

        generatedMessage.append(rawTemplate.substring(i));
        return generatedMessage + ". Sent to " + client.getAddresses();

    }

    private Map<String, String> preprocessValues(Map<String, String> values) {
        Map<String, String> processedValues = new HashMap<>();
        for (Map.Entry<String, String> entry : values.entrySet()) {
            processedValues.put("#{" + entry.getKey() +"}", entry.getValue());
        }

        return processedValues;
    }

}
