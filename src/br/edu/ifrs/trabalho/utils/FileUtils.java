package br.edu.ifrs.trabalho.utils;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

//Rafael Graunke


public class FileUtils {

    public static final int PDF = 1;
    public static final int EXCEL = 2;

    public static File chooseSaveFile(int type) {
        Stage stage = new Stage();
        FileChooser fc = new FileChooser();
        switch (type) {
            case 1:
                fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF", "*.pdf"));
                break;
            case 2:
                fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel 2007 - 365", "*.xlsx"));
                break;
        }
        return fc.showSaveDialog(stage);

    }

}
