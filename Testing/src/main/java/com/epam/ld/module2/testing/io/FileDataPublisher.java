package com.epam.ld.module2.testing.io;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

import com.epam.ld.module2.testing.exception.UnresolvablePathException;

public class FileDataPublisher {

    public String publishData(String filePath, String data) {
        try {
            File outputFile = new File(filePath);
            FileUtils.writeStringToFile(outputFile, data, StandardCharsets.UTF_8);
            return outputFile.getAbsolutePath();
        } catch (IOException e) {
            throw new UnresolvablePathException("Could not to resolve the path: " + filePath);
        }
    }

}
