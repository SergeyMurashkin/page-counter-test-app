package ru.murashkin.testapp.ecmc.pageCounterConsoleApp;

import ru.murashkin.testapp.ecmc.pageCounterConsoleApp.fileHandler.PageCounter;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PageCounterConsoleApp {

    private static final String DEFAULT_PATH = "./";

    public static void main(String[] args) {
        Path initialPath = findPathInProgramArgumentsOrDefaultPath(args);
        System.out.println("Начальный путь к папке: " + initialPath);

        File initialFile = initialPath.toFile();

        PageCounter pageCounter = new PageCounter();
        pageCounter.countFilesAndSumOfPagesIn(initialFile);
        pageCounter.getResultOfCount();
    }

    private static Path findPathInProgramArgumentsOrDefaultPath(String[] args) {

        if (args.length > 0) {
            String pathString = args[0];
            return Paths.get(pathString);
        }

        System.out.println("Вы не указали путь к начальной папке. Будет выбрана директория по-умолчанию.");
        return Paths.get(DEFAULT_PATH);
    }
}
