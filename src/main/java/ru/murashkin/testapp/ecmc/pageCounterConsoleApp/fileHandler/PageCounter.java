package ru.murashkin.testapp.ecmc.pageCounterConsoleApp.fileHandler;

import org.apache.commons.io.FilenameUtils;
import ru.murashkin.testapp.ecmc.pageCounterConsoleApp.fileExtension.FileExtension;
import ru.murashkin.testapp.ecmc.pageCounterConsoleApp.fileHandler.pageableFileHandler.DocFileHandler;
import ru.murashkin.testapp.ecmc.pageCounterConsoleApp.fileHandler.pageableFileHandler.DocxDocx4jFileHandler;
import ru.murashkin.testapp.ecmc.pageCounterConsoleApp.fileHandler.pageableFileHandler.IPageableFileHandler;
import ru.murashkin.testapp.ecmc.pageCounterConsoleApp.fileHandler.pageableFileHandler.PdfFileHandler;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class PageCounter {

    Map<FileExtension, IPageableFileHandler> extensionToHandlerMap;
    Integer countOfDirectories = 0;
    Integer countOfFiles = 0;
    Integer countOfHandledFiles = 0;
    Integer countOfPages = 0;

    public PageCounter() {
        extensionToHandlerMap = new HashMap<>() {{
            put(FileExtension.DOC, new DocFileHandler());
            put(FileExtension.DOCX, new DocxDocx4jFileHandler());
            put(FileExtension.PDF, new PdfFileHandler());
        }};
    }


    public void countFilesAndSumOfPagesIn(File initialFile) {

        if (initialFile.isFile()) {
            countOfFiles++;

            String extension = FilenameUtils.getExtension(initialFile.getName());
            if (extension == null || extension.isEmpty()) {
                System.out.println("Отсутствует расширение у файла: " + initialFile);
                return;
            }

            FileExtension fileExtension = FileExtension.findByExtension(extension);
            if (fileExtension == null) {
                System.out.println("Неизвестное расширение: " + extension + " у файла: " + initialFile);
                return;
            }

            IPageableFileHandler fileHandler = extensionToHandlerMap.get(fileExtension);
            if (fileHandler == null) {
                System.out.println("Нет обработчика для расширения: " + extension + " файла: " + initialFile);
                return;
            }

            Integer countPagesInFile = fileHandler.countPagesInFile(initialFile);
            if (countPagesInFile == null) {
                System.out.println("Не смог посчитать количество страниц в файле: " + initialFile);
                return;
            }

            countOfHandledFiles++;
            countOfPages += countPagesInFile;
        } else {
            countOfDirectories++;

            File[] files = initialFile.listFiles();
            if (files == null) {
                return;
            }

            for (File file : files) {
                countFilesAndSumOfPagesIn(file);
            }
        }

    }

    public void getResultOfCount() {
        System.out.println("");
        System.out.println("Директорий : " + countOfDirectories);
        System.out.println("Файлов : " + countOfFiles);
        System.out.println("Обработанных файлов : " + countOfHandledFiles);
        System.out.println("Страниц : " + countOfPages);
    }

}
