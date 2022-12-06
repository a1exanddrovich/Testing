package com.epam.ld.module2.testing.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import com.epam.ld.module2.testing.exception.UnresolvablePathException;

public class FileDataReader {

    public String readData(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> lines = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            lines.forEach(line -> contentBuilder.append(line).append("\n"));
        } catch (IOException e) {
            throw new UnresolvablePathException("Could not to resolve the path: " + filePath);
        }

        return StringUtils.chop(contentBuilder.toString());
    }

}
