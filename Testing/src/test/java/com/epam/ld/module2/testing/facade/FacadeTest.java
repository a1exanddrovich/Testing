package com.epam.ld.module2.testing.facade;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.epam.ld.module2.testing.entity.Client;
import com.epam.ld.module2.testing.io.FileDataPublisher;
import com.epam.ld.module2.testing.io.FileDataReader;
import com.epam.ld.module2.testing.logic.Messenger;
import com.epam.ld.module2.testing.template.Template;
import com.epam.ld.module2.testing.utils.DataParser;

@Tag("facade")
@ExtendWith(MockitoExtension.class)
class FacadeTest {

    @Mock
    private FileDataReader dataReader;
    @Spy
    private DataParser dataParser;
    @Mock
    private FileDataPublisher dataPublisher;
    @Mock
    private Messenger messenger;
    @InjectMocks
    private Facade sut;

    @Test
    @DisabledIf("runFacadeTests")
    void shouldExecuteInFileMode() {
        String filePath = "src/test/resources/testFacade.txt";
        String outputFilePath = "src/test/resources/";
        String rawData = "Hello! I wanted to share #{item} with you\n" +
                "item=this\n" +
                "Client1@mail.ru";

        when(dataReader.readData(filePath)).thenReturn(rawData);

        Template template = dataParser.parseData(Template.class, rawData);
        Client client = dataParser.parseData(Client.class, rawData);

        doNothing().when(messenger).sendMessage(client, template);
        doNothing().when(dataPublisher).publishData(anyString(), anyString());

        sut.execute(true, filePath, outputFilePath);

        verify(dataReader, times(1)).readData(anyString());
        verify(dataParser, times(2)).parseData(any(), anyString());
        verify(dataPublisher, times(1)).publishData(anyString(), anyString());
        verify(messenger, times(1)).sendMessage(any(Client.class), any(Template.class));
    }

    private boolean runFacadeTests() {
        return true;
    }

}
