package br.edu.ifrs.trabalho.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("views/MainPane.fxml"));
			Stage stage = new Stage();
			stage.setTitle("My New Stage Title");
			stage.setScene(new Scene(root, 700, 600));
			stage.setResizable(false);
			stage.show();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
