package com.example.lab2;

import com.example.lab2.excel.Calculations;
import com.example.lab2.excel.Export;
import com.example.lab2.excel.Import;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;

public class Controller {

    // Исключеия, вывод текста при нажатии кнопок и мб разобраться как работают вычисления, но впадлу

    Calculations calc = new Calculations();
    Import imp = new Import();
    Export exp = new Export();

    @FXML
    private Button exitBtn;

    @FXML
    private Button exportBtn;

    @FXML
    private Button importBtn;

    @FXML
    void importFile(ActionEvent event) throws IOException, InvalidFormatException {
        FileChooser fc = new FileChooser();
        File file = fc.showOpenDialog(null);

        if (file != null) {
            imp.arr(file);
            calc.calc(imp.getArr());
        }
    }

    @FXML
    void exportFile(ActionEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        File file = fc.showSaveDialog(null);

        if (file != null) {
            exp.export(imp.getArr(), calc.getLhm(), file);
        }

    }

    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }

}