package br.edu.ifrs.trabalho.app;

import java.io.IOException;
import br.edu.ifrs.trabalho.controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	public static final String MAIN = "resources/views/MainPane.fxml";
	public static final String EXPORT = "resources/views/ExportPane.fxml";
	public static final String ADC = "resources/views/AdcPane.fxml";
	public static final String GRAPH = "resources/views/GraphPane.fxml";

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		openNewWindow(MAIN, "Main", 700, 600, new Controller());
	}

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
			stage.show();
		} catch (IOException e) {
			System.err.println("Deu ruim!"); // TODO: Criar janela de erro
		}

	}
}
