package br.edu.ifrs.trabalho.controller;

import br.edu.ifrs.trabalho.app.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {
    @FXML
    Button add_btn, remove_btn, export_btn, stats_btn;

    public void showStats() {
        App.openNewWindow(App.GRAPH, "Adc", 600, 500);
    }

    public void showAdc() {
        App.openNewWindow(App.ADC, "Adc", 600, 500);
    }

    public void showExport() {
        App.openNewWindow(App.EXPORT, "Adc", 600, 500);
    }
}
