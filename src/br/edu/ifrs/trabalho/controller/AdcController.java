package br.edu.ifrs.trabalho.controller;

import br.edu.ifrs.trabalho.model.Jogo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

//Rafael Graunke
public class AdcController extends Controller implements Initializable {

    @FXML
    TextField name_field, developer_field, year_field;

    @FXML
    ChoiceBox<String> category_choice;

    @FXML
    Button back_btn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        category_choice.getItems().add("RPG");
        category_choice.getItems().add("FPS");
        category_choice.getItems().add("Terror");
        category_choice.getItems().add("Puzzle");
    }

    public void adiciona() {
        Jogo jogo = new Jogo();
        jogo.setNome(name_field.getText());
        jogo.setDesenvolvedor(developer_field.getText());
        jogo.setCategoria(category_choice.getSelectionModel().getSelectedItem());
        jogo.setAno(Integer.parseInt(year_field.getText()));
        ((MainController) main_controller).getJogos().add(jogo);
    }

    public void voltar() {
        Stage stage = (Stage) back_btn.getScene().getWindow();
        stage.close();
    }
}
