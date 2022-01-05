package br.edu.ifrs.trabalho.controller;

import br.edu.ifrs.trabalho.app.App;
import br.edu.ifrs.trabalho.model.Jogo;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

//Rafael Graunke
public class MainController extends Controller implements Initializable {

    private final ObservableList<Jogo> jogos = FXCollections.observableArrayList();

    @FXML
    TableView<Jogo> table_view;

    @FXML
    Button add_btn, remove_btn, export_btn, stats_btn;

    @FXML
    TableColumn<Jogo, String> name_col, dev_col, cat_col;

    @FXML
    TableColumn<Jogo, Integer> year_col;

    public void showStats() {
        App.openNewWindow(App.GRAPH, "Adc", 600, 500, this);
    }

    public void showAdc() {
        App.openNewWindow(App.ADC, "Adc", 600, 500, this);
    }

    public void showExport() {
        App.openNewWindow(App.EXPORT, "Adc", 600, 500, this);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name_col.setCellValueFactory(jogos -> new SimpleStringProperty(jogos.getValue().getNome()));
        dev_col.setCellValueFactory(jogos -> new SimpleStringProperty(jogos.getValue().getDesenvolvedor()));
        cat_col.setCellValueFactory(jogos -> new SimpleStringProperty(jogos.getValue().getCategoria()));
        year_col.setCellValueFactory(jogos -> new SimpleObjectProperty<>(jogos.getValue().getAno()));

        table_view.setItems(jogos);
    }

    public ObservableList<Jogo> getJogos() {
        return jogos;
    }
}
