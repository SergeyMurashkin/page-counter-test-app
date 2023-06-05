package ru.murashkin.testapp.ecmc.pageCounterConsoleApp.fileHandler.pageableFileHandler;

import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

import java.io.File;

public class DocxDocx4jFileHandler implements IPageableFileHandler {

    @Override
    public Integer countPagesInFile(File file) {

        try {
            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(file);
            int pagesCount = wordMLPackage.getDocPropsExtendedPart().getJaxbElement().getPages();
            return pagesCount;
        } catch (Exception e) {
            return null;
        }
    }

}
