package ru.murashkin.testapp.ecmc.pageCounterConsoleApp.fileHandler.pageableFileHandler;

import ru.murashkin.testapp.ecmc.pageCounterConsoleApp.fileHandler.IFileHandler;

import java.io.File;

public interface IPageableFileHandler extends IFileHandler {

    /**
     * Метод получения количества страниц в документе.
     *
     * @param file путь к файлу
     * @return Метод должен возвращать число страниц при успешном выполнении. <p>
     * В ошибочном случае нужно вернуть null.
     */
    default Integer countPagesInFile(File file) {
        return null;
    }

    /**
     * Метод проверки документа перед подсчётом страниц.
     *
     * @param file путь к файлу
     * @return Метод должен true если: <p>
     * Является файлом <p>
     * Файл существует <p>
     * Есть доступ для чтения <p>
     */
    default boolean isFileAvailableForPageCounting(File file) {
        try {
            return file.isFile() && file.exists() && file.canRead();
        } catch (Exception e) {
            return false;
        }
    }
}
