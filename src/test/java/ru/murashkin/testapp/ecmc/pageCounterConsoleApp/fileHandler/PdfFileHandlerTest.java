package ru.murashkin.testapp.ecmc.pageCounterConsoleApp.fileHandler;

import org.junit.jupiter.api.Test;
import ru.murashkin.testapp.ecmc.pageCounterConsoleApp.fileHandler.pageableFileHandler.PdfFileHandler;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PdfFileHandlerTest {

    PdfFileHandler pdfFileHandler = new PdfFileHandler();

    String commonPathToTestPdfFiles = "src/test/resources/filesForTest/pdf/";

    @Test
    void testFileWithoutExtensionPageCount() {
        String fileWithoutExtensionName = "pdf_2_pages_without_extension";
        Integer expectedPageCount = 2;

        File fileWithoutExtension = new File(commonPathToTestPdfFiles + fileWithoutExtensionName);
        Integer countOfPages = pdfFileHandler.countPagesInFile(fileWithoutExtension);

        assertEquals(expectedPageCount, countOfPages);
    }

    @Test
    void testFile_2Page_PageCount() {
        String fileName = "pdf_2_pages.pdf";
        Integer expectedPageCount = 2;

        File fileWithoutExtension = new File(commonPathToTestPdfFiles + fileName);
        Integer countOfPages = pdfFileHandler.countPagesInFile(fileWithoutExtension);

        assertEquals(expectedPageCount, countOfPages);
    }

    @Test
    void testFile_59Page_PageCount() {
        String fileName = "pdf_59_pages.pdf";
        Integer expectedPageCount = 59;

        File fileWithoutExtension = new File(commonPathToTestPdfFiles + fileName);
        Integer countOfPages = pdfFileHandler.countPagesInFile(fileWithoutExtension);

        assertEquals(expectedPageCount, countOfPages);
    }

}
