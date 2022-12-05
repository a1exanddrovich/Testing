package com.epam.ld.module2.testing.cli;

import picocli.CommandLine;

import com.epam.ld.module2.testing.facade.Facade;
import com.epam.ld.module2.testing.io.FileDataReader;
import com.epam.ld.module2.testing.logic.MailServer;
import com.epam.ld.module2.testing.logic.Messenger;
import com.epam.ld.module2.testing.template.TemplateEngine;

@CommandLine.Command(
        name = "messenger",
        description = "The entity pretends to send emails using a custom template generator"
)
public class CommandLineInterface implements Runnable {

    @CommandLine.Option(names = "-enableFileMode")
    private boolean fileModeOn;

    @CommandLine.Option(names = "-inputTemplate")
    private String inputTemplate;

    @CommandLine.Option(names = "outputFolder")
    private String outputFolder;

    public void run() {
        FileDataReader fileDataReader = new FileDataReader();
        TemplateEngine templateEngine = new TemplateEngine();
        MailServer mailServer = new MailServer();
        Messenger messenger = new Messenger(mailServer, templateEngine);
        Facade facade = new Facade(fileDataReader, templateEngine, messenger, mailServer);
        facade.execute(fileModeOn, inputTemplate, outputFolder);
    }

}