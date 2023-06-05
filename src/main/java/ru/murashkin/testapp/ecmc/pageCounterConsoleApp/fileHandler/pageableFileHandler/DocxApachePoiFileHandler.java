package ru.murashkin.testapp.ecmc.pageCounterConsoleApp.fileHandler.pageableFileHandler;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;


/**
 * Обработчик DOCX документов с помощью библиотеки ApachePoi. <p>
 * Устарел, в связи с отсутствием возможности корректного подсчёта страниц непересохранённого документа. <p>
 */
@Deprecated
public class DocxApachePoiFileHandler implements IPageableFileHandler {

    @Override
    public Integer countPagesInFile(File file) {

        try {
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            XWPFDocument docx = new XWPFDocument(fis);
            int pagesCount = docx.getProperties().getExtendedProperties().getUnderlyingProperties().getPages();

            return pagesCount;
        } catch (Exception e) {
            return null;
        }
    }

}
