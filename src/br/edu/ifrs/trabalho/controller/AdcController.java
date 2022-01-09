package br.edu.ifrs.trabalho.controller;

import java.net.URL;
import java.util.ResourceBundle;
import br.edu.ifrs.trabalho.app.App;
import br.edu.ifrs.trabalho.model.Jogo;
import br.edu.ifrs.trabalho.repository.JogoRepository;
import br.edu.ifrs.trabalho.utils.AlertUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

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
		category_choice.getItems().addAll("Sandbox", "RTS", "Tiro", "MOBA", "RPG", "Simulador", "Esporte", "Puzzle",
				"Party", "Acao", "Aventura", "Luta", "Sobrevivencia", "Terror", "Plataforma");
		category_choice.getSelectionModel().selectFirst();
	}

	public void adiciona() {
		Jogo jogo = new Jogo();
		boolean erro = false;
		for (TextField field : new TextField[]{name_field, developer_field, year_field}) {
			if (field.getText().trim().isEmpty()) {
				erro = true;
			}
		}
		if (erro) {
			AlertUtils.mostrarAlert("Não foi possivel adicionar um novo jogo, Verifique que todos os campos estao preenchidos.", Alert.AlertType.ERROR);
		} else {
			try {
				int ano = Integer.parseInt(year_field.getText());
				jogo.setNome(name_field.getText());
				jogo.setDesenvolvedor(developer_field.getText());
				jogo.setCategoria(category_choice.getSelectionModel().getSelectedItem());
				jogo.setAno(ano);
				JogoRepository.adiciona(jogo);
				App.fecharStage(back_btn);
				App.openNewWindow(App.MAIN, "Main", 700, 600, new Controller());
			} catch (NumberFormatException e) {
				AlertUtils.mostrarAlert("O campo de ano deve ser um numero inteiro.", Alert.AlertType.ERROR);
			}
		}

	}

	public void voltar() {
		App.fecharStage(back_btn);
		App.openNewWindow(App.MAIN, "Main", 700, 600, new Controller());
	}
}
