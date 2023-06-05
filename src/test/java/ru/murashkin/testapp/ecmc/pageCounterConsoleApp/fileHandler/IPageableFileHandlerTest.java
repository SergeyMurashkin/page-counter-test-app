package ru.murashkin.testapp.ecmc.pageCounterConsoleApp.fileHandler;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.murashkin.testapp.ecmc.pageCounterConsoleApp.fileHandler.pageableFileHandler.IPageableFileHandler;

import java.io.File;

import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.mockito.Mockito.spy;

public class IPageableFileHandlerTest {

    IPageableFileHandler iPageableFileHandler = spy(IPageableFileHandler.class);

    @Test
    void testDirectoryFileForAvailable() {
        String directoryPath = "src/test/resources/filesForTest/iPageableFileHandlerFile";
        File directoryFile = new File(directoryPath);

        boolean isAvailableFile = iPageableFileHandler.isFileAvailableForPageCounting(directoryFile);

        assumeFalse(isAvailableFile);
    }

    @Test
    void testNonExistingFileForAvailable() {
        String directoryPath = "src/test/resources/nonExistingPath";
        File directoryFile = new File(directoryPath);

        boolean isAvailableFile = iPageableFileHandler.isFileAvailableForPageCounting(directoryFile);

        assumeFalse(isAvailableFile);
    }

    @Test
//    @Disabled("Сначала нужно создать и заблокировать доступ на чтение к файлу nonReadablePdfFile.pdf")
    void testNonReadableFileForAvailable() {
        String directoryPath = "src/test/resources/filesForTest/iPageableFileHandlerFile/nonReadablePdfFile.pdf";
        File directoryFile = new File(directoryPath);

        boolean isAvailableFile = iPageableFileHandler.isFileAvailableForPageCounting(directoryFile);

        assumeFalse(isAvailableFile);
    }

    @Test
    void testNormalFileForAvailable() {
        String directoryPath = "src/test/resources/filesForTest/iPageableFileHandlerFile/normal_file.pdf";
        File directoryFile = new File(directoryPath);

        boolean isAvailableFile = iPageableFileHandler.isFileAvailableForPageCounting(directoryFile);

        assumeTrue(isAvailableFile);
    }
}
