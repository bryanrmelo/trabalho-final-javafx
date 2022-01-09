package br.edu.ifrs.trabalho.controller;

import java.net.URL;
import java.util.ResourceBundle;
import br.edu.ifrs.trabalho.app.App;
import br.edu.ifrs.trabalho.model.Jogo;
import br.edu.ifrs.trabalho.repository.JogoRepository;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

//Rafael Graunke
public class MainController extends Controller implements Initializable {

	private JogoRepository jogoRepo = new JogoRepository();

	public static Jogo JogoSelecionado = null;

	@FXML
	TableView<Jogo> table_view;

	@FXML
	Button add_btn, remove_btn, export_btn, stats_btn, edit_btn;

	@FXML
	TableColumn<Jogo, String> name_col, dev_col, cat_col;

	@FXML
	TableColumn<Jogo, Integer> year_col;

	@SuppressWarnings("static-access")
	@FXML
	public void removeButtonHandler(ActionEvent event) {
		Jogo jogo = table_view.getSelectionModel().getSelectedItem();
		jogoRepo.remove(jogo);
		table_view.getItems().setAll(FXCollections.observableArrayList(jogoRepo.buscarTodos()));

	}

	public void showAdc() {
		App.fecharStage(add_btn);
		App.openNewWindow(App.ADC, "Adicionar", 500, 400, this);
	}

	public void showExport() {
		App.fecharStage(export_btn);
		App.openNewWindow(App.EXPORT, "Exportar", 314, 178, this);
	}

	public void showStats() {
		App.fecharStage(stats_btn);
		App.openNewWindow(App.GRAPH, "Estatísticas", 600, 525, this);
	}

	// Mateus Zucco
	public void showEdit() {
		Jogo jogo = table_view.getSelectionModel().getSelectedItem();
		JogoSelecionado = jogo;
		App.fecharStage(edit_btn);
		App.openNewWindow(App.EDIT, "Editar", 500, 400, this);
	}

	@SuppressWarnings("static-access")
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		name_col.setCellValueFactory(new PropertyValueFactory<Jogo, String>("nome"));
		dev_col.setCellValueFactory(new PropertyValueFactory<Jogo, String>("desenvolvedor"));
		cat_col.setCellValueFactory(new PropertyValueFactory<Jogo, String>("categoria"));
		year_col.setCellValueFactory(new PropertyValueFactory<Jogo, Integer>("ano"));

		table_view.getItems().setAll(FXCollections.observableArrayList(jogoRepo.buscarTodos()));
	}

}
