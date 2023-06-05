package ru.murashkin.testapp.ecmc.pageCounterConsoleApp.fileHandler.pageableFileHandler;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;

public class PdfFileHandler implements IPageableFileHandler {

    @Override
    public Integer countPagesInFile(File file) {

        if (!isFileAvailableForPageCounting(file)) {
            return null;
        }

        try {
            PDDocument pdfDocument = PDDocument.load(file);
            return pdfDocument.getNumberOfPages();
        } catch (IOException e) {
            System.out.println("Не могу обработать файл: " + file);
            return null;
        }
    }
}
