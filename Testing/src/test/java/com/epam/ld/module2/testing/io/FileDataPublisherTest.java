package com.epam.ld.module2.testing.io;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;

import com.epam.ld.module2.testing.extension.TestReporterPostProcessorExtension;

import lombok.SneakyThrows;

@Tag("io")
//@ExtendWith(TestReporterPostProcessorExtension.class)
class FileDataPublisherTest {

    private final FileDataPublisher sut = new FileDataPublisher();

    @Test
    @SneakyThrows
    @EnabledOnOs(value = OS.WINDOWS)
    void shouldReadDataFromTemporaryFile(@TempDir Path tempDir) {
        Path path = tempDir.resolve("tempDataToWrite.txt");

        List<String> data = Arrays.asList("Written Data temporary");

        sut.publishData(path.toAbsolutePath().toString(), data.get(0));

        assertTrue(Files.exists(path));
        assertLinesMatch(Files.readAllLines(path), data);
    }

}
