package com.example.lab2;

import com.example.lab2.excel.Calculations;
import com.example.lab2.excel.Export;
import com.example.lab2.excel.Import;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class Controller {

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
    void importFile(ActionEvent event) {

        FileChooser fc = new FileChooser();
        File file = fc.showOpenDialog(null);

        try {
            imp.arr(file);
            calc.calc(imp.getArr());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Import");
            alert.setHeaderText(null);
            alert.setContentText("Файл загружен");
            alert.showAndWait();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Ошибка в пути файла");
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Ошибка в формате файла.");
            alert.showAndWait();
        }

    }

    @FXML
    void exportFile(ActionEvent event) {
        FileChooser fc = new FileChooser();
        File file = fc.showSaveDialog(null);

        try {
            exp.export(imp.getArrNames(), calc.getLhm(), file);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Import");
            alert.setHeaderText(null);
            alert.setContentText("Файл сохранен");
            alert.showAndWait();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Ошибка в пути файла");
            alert.showAndWait();
        }


    }

    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }

}