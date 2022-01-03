package br.edu.ifrs.trabalho.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

	public static final String MAIN = "views/MainPane.fxml";
	public static final String EXPORT = "views/ExportPane.fxml";
	public static final String ADC = "views/AdcPane.fxml";
	public static final String GRAPH = "views/GraphPane.fxml";

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		openNewWindow(MAIN, "Main", 700, 600);
	}

	public static void openNewWindow(String path, String title, int w, int h) {
		Stage stage = new Stage();
		try {
			Parent root = FXMLLoader.load(App.class.getClassLoader().getResource(path));
			Scene scene = new Scene(root, w, h);
			stage.setScene(scene);
			stage.show();
			stage.setTitle(title);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			System.err.println("Deu ruim!"); //TODO: Criar janela de erro
		}

	}
}
