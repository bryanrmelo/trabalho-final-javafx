package br.edu.ifrs.trabalho.controller;

import br.edu.ifrs.trabalho.app.App;
import br.edu.ifrs.trabalho.exceptions.SenhaInvalidaException;
import br.edu.ifrs.trabalho.exceptions.UsuarioNaoEncontrado;
import br.edu.ifrs.trabalho.model.Usuario;
import br.edu.ifrs.trabalho.repository.UsuarioRepository;
import br.edu.ifrs.trabalho.utils.AlertUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

//Bryan Melo

public class LoginController extends Controller {

	@FXML
	private TextField login;

	@FXML
	private PasswordField senha;

	@FXML
	private Button entrarButton;

	@FXML
	void botaoEntrarHandler(ActionEvent event) {
		Usuario usuario = new Usuario(login.getText(), senha.getText());
		try {
			if (UsuarioRepository.logar(usuario)) {
				App.fecharStage(entrarButton);
				App.openNewWindow(App.MAIN, "Main", 700, 600, new Controller());
			} else {
				AlertUtils.mostrarAlert("Usu?rio ou senha erradas", AlertType.INFORMATION);
			}

		} catch (SenhaInvalidaException e) {
			AlertUtils.mostrarAlert(e.getMessage(), AlertType.WARNING);

		} catch (UsuarioNaoEncontrado e) {
			AlertUtils.mostrarAlert(e.getMessage(), AlertType.ERROR);

		}
	}

}
