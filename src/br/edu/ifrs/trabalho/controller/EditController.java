package br.edu.ifrs.trabalho.controller;

import static br.edu.ifrs.trabalho.controller.MainController.JogoSelecionado;
import java.net.URL;
import java.util.ResourceBundle;
import br.edu.ifrs.trabalho.app.App;
import br.edu.ifrs.trabalho.model.Jogo;
import br.edu.ifrs.trabalho.repository.JogoRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

//Mateus Zucco
public class EditController extends Controller implements Initializable {
	@FXML
	TextField name_field, developer_field, year_field;

	@FXML
	ChoiceBox<String> category_choice;

	@FXML
	Button back_btn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		category_choice.getItems().addAll("Sandbox", "RTS", "Tiro", "MOBA", "RPG", "Simulador", "Esporte", "Puzzle", "Party", "Acao", "Aventura",
						"Luta", "Sobrevivencia", "Terror", "Plataforma");
		name_field.setText(JogoSelecionado.getNome());
		developer_field.setText(JogoSelecionado.getDesenvolvedor());
		year_field.setText(String.valueOf(JogoSelecionado.getAno()));
		category_choice.setValue(JogoSelecionado.getCategoria());
	}

	public void voltar(ActionEvent actionEvent) {
		App.fecharStage(back_btn);
		App.openNewWindow(App.MAIN, "Main", 700, 600, new Controller());
	}

	public void edita(ActionEvent actionEvent) {
		Jogo jogo = new Jogo();
		jogo.setId(JogoSelecionado.getId());
		jogo.setNome(name_field.getText());
		jogo.setDesenvolvedor(developer_field.getText());
		jogo.setAno(Integer.parseInt(year_field.getText()));
		jogo.setCategoria(category_choice.getValue());

		JogoRepository.alterar(jogo);
		App.fecharStage(back_btn);
		App.openNewWindow(App.MAIN, "Main", 700, 600, new Controller());
	}
}
