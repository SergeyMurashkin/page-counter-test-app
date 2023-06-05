package ru.murashkin.testapp.ecmc.pageCounterConsoleApp.fileHandler;

import org.junit.jupiter.api.Test;
import ru.murashkin.testapp.ecmc.pageCounterConsoleApp.fileHandler.pageableFileHandler.DocxDocx4jFileHandler;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DocxDocx4jFileHandlerTest {

    DocxDocx4jFileHandler docxDocx4jFileHandler = new DocxDocx4jFileHandler();

    String commonPathToTestDocxFiles = "src/test/resources/filesForTest/docx/";

    @Test
    void testFileWithoutSavePageCount() {
        String notSavedFileName = "docx_5_pages_not_saved.docx";
        File notSavedFile = new File(commonPathToTestDocxFiles + notSavedFileName);
        Integer countOfPages = docxDocx4jFileHandler.countPagesInFile(notSavedFile);

        assertNull(countOfPages);
    }

    @Test
    void testFile_4Page_PageCount() {
        String fileName = "docx_4_pages.docx";
        Integer expectedPageCount = 4;

        File file = new File(commonPathToTestDocxFiles + fileName);
        Integer countOfPages = docxDocx4jFileHandler.countPagesInFile(file);

        assertEquals(expectedPageCount, countOfPages);
    }

    @Test
    void testFile_5Page_PageCount() {
        String fileName = "docx_5_pages.docx";
        Integer expectedPageCount = 5;

        File file = new File(commonPathToTestDocxFiles + fileName);
        Integer countOfPages = docxDocx4jFileHandler.countPagesInFile(file);

        assertEquals(expectedPageCount, countOfPages);
    }

}
