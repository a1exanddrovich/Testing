package com.epam.ld.module2.testing.utils;

import com.epam.ld.module2.testing.template.Template;

public class DataParser {

    public <T> T parseData(Class<T> clazz, String data) {
        return (T) (clazz.equals(Template.class)
                                ? parseTemplate(data)
                                : parseClient(data));
    }

    private Object parseTemplate(String data) {
        return null;
    }

    private Object parseClient(String data) {
        return null;
    }

}
