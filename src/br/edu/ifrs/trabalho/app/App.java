package br.edu.ifrs.trabalho.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class App extends Application {
	private static Scene mainScene;
	private static Scene GraphScene;
	private static Scene ExportScene;
	private static Scene AdcScene;
	private static Stage stage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		Parent register;
		try {
			stage = primaryStage;
			Parent root = FXMLLoader.load(getClass().getResource("MainPane.fxml"));
			mainScene = new Scene(root, 600, 550);
			primaryStage.setScene(mainScene);
			primaryStage.show();
			stage.setTitle("Colocar um Titulo");
			stage.setScene(mainScene);
			stage.show();

			register = FXMLLoader.load(getClass().getResource("GraphPane.fxml"));
			GraphScene = new Scene(register, 620, 600);

			register = FXMLLoader.load(getClass().getResource("ExportPane.fxml"));
			ExportScene = new Scene(register, 620, 600);

			register = FXMLLoader.load(getClass().getResource("AdcPane.fxml"));
			AdcScene = new Scene(register, 620, 600);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void changeScene(String scene) throws SQLException {
		switch (scene) {
			case "main":
				stage.setScene(mainScene);
				break;
			case "graph":
				stage.setScene(GraphScene);
				break;
			case "adc":
				stage.setScene(AdcScene);
				break;
			case "export":
				stage.setScene(ExportScene);
				break;
		}
	}
}
