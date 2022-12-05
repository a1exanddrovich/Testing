package com.epam.ld.module2.testing.facade;

import lombok.AllArgsConstructor;

import java.util.List;

import com.epam.ld.module2.testing.entity.Client;
import com.epam.ld.module2.testing.io.FileDataReader;
import com.epam.ld.module2.testing.logic.MailServer;
import com.epam.ld.module2.testing.logic.Messenger;
import com.epam.ld.module2.testing.template.TemplateEngine;

@AllArgsConstructor
public class Facade {

    private final FileDataReader dataReader;
    private final TemplateEngine templateEngine;
    private final Messenger messenger;
    private final MailServer mailServer;

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
