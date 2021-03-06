package br.edu.ifrs.trabalho.app;

import java.io.IOException;
import br.edu.ifrs.trabalho.controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

//Rafael Graunke
public class App extends Application {

	public static final String LOGIN = "resources/views/LoginPane.fxml";
	public static final String MAIN = "resources/views/MainPane.fxml";
	public static final String EXPORT = "resources/views/ExportPane.fxml";
	public static final String EDIT = "resources/views/EditPane.fxml";
	public static final String ADC = "resources/views/AdcPane.fxml";
	public static final String GRAPH = "resources/views/GraphPane.fxml";

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		openNewWindow(LOGIN, "Login", 700, 600, new Controller());
	}

	//Rafael Graunke
	public static void openNewWindow(String path, String title, int w, int h, Controller mainController) {
		Stage stage = new Stage();
		Parent root;
		try {
			FXMLLoader loader = new FXMLLoader(mainController.getClass().getClassLoader().getResource(path));
			root = loader.load();
			Controller controller = loader.getController();
			controller.setMainController(mainController);
			Scene scene = new Scene(root, w, h);
			stage.setScene(scene);
			stage.show();
			stage.setTitle(title);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Deu ruim!"); // TODO: Criar janela de erro
		}

	}

	public static void fecharStage(Button button) {
		Stage stage = (Stage) button.getScene().getWindow();
		stage.close();

	}
}
