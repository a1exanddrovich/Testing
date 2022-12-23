package com.epam.ld.module2.testing.facade;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.epam.ld.module2.testing.entity.Client;
import com.epam.ld.module2.testing.io.FileDataPublisher;
import com.epam.ld.module2.testing.io.FileDataReader;
import com.epam.ld.module2.testing.logic.Messenger;
import com.epam.ld.module2.testing.template.Template;
import com.epam.ld.module2.testing.template.TemplateEngine;
import com.epam.ld.module2.testing.utils.DataParser;

@AllArgsConstructor
public class Facade {

    private final FileDataReader dataReader;
    private final FileDataPublisher dataPublisher;
    private final DataParser dataParser;
    private final Messenger messenger;
    private final TemplateEngine templateEngine;

    public void execute(boolean fileModeOn, String inputTemplateFile, String outputFile) {
        if (fileModeOn) {
            processViaFiles(inputTemplateFile, outputFile);
        } else {
            processViaConsole();
        }
    }

    private void processViaFiles(String inputTemplateFile, String outputFile) {
        String rawData = dataReader.readData(inputTemplateFile);
        Template template = dataParser.parseData(Template.class, rawData);
        Client client = dataParser.parseData(Client.class, rawData);
        messenger.sendMessage(client, template);
        dataPublisher.publishData(outputFile, templateEngine.generateMessage(template, client));
    }

    @SneakyThrows
    private void processViaConsole() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a template: ");
        StringBuilder rawData = new StringBuilder(reader.readLine()).append("\n");
        System.out.println("Enter values: ");
        rawData.append(reader.readLine()).append("\n");
        System.out.println("Enter a client: ");
        rawData.append(reader.readLine()).append("\n");
        Template template = dataParser.parseData(Template.class, rawData.toString());
        Client client = dataParser.parseData(Client.class, rawData.toString());
        messenger.sendMessage(client, template);
        System.out.println(templateEngine.generateMessage(template, client));
    }

}
