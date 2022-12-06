package com.epam.ld.module2.testing.facade;

import lombok.AllArgsConstructor;

import com.epam.ld.module2.testing.io.FileDataPublisher;
import com.epam.ld.module2.testing.io.FileDataReader;
import com.epam.ld.module2.testing.logic.Messenger;
import com.epam.ld.module2.testing.utils.DataParser;

@AllArgsConstructor
public class Facade {

    private final FileDataReader dataReader;
    private final FileDataPublisher dataPublisher;
    private final DataParser dataParser;
    private final Messenger messenger;

    public void execute(boolean fileModeOn, String inputTemplateFile, String outputFolder) {
        if (fileModeOn) {
            processViaFiles(inputTemplateFile, outputFolder);
        } else {
            processViaConsole();
        }
    }

    private void processViaFiles(String inputTemplateFile, String outputFolder) {

    }

    private void processViaConsole() {

    }

}
