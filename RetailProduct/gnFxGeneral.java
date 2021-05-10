package RetailProduct;

import java.util.Optional;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

public class gnFxGeneral {

	public void showAlert(String vtext, String valertText) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Warning Dialog");
		alert.setHeight(150);
		alert.setHeaderText(vtext);
		alert.setContentText(valertText);
		alert.show();
		// new gnImageSound().playAlertSound();
		alert.setHeight(150);
	}

	public void showError(String htext, String verror) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText(htext);
		alert.setContentText(verror);
		alert.showAndWait();
	}

	public String showInputdialog(String msg, String Question) {
		String result;
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog");
		alert.setHeaderText(msg);
		alert.setContentText(Question);

		Optional<ButtonType> result1 = alert.showAndWait();
		if (result1.get() == ButtonType.OK) {
			result = "Y";
		} else {
			result = "N";
		}
		return result;
	}

	public String userInput() {
		String value = " ";
		TextInputDialog dialog = new TextInputDialog("walter");
		dialog.setTitle("Text Input Dialog");
		dialog.setHeaderText("Look, a Text Input Dialog");
		dialog.setContentText("Please enter your name:");

		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()) {
			value = result.get();
			// System.out.println("Your name: " + result.get());
		}
		return value;

		// The Java 8 way to get the response value (with lambda expression).
		// result.ifPresent(name -> System.out.println("Your name: " + name));
	}

	public void authorize() {
		// Create the custom dialog.
		Dialog<Pair<String, String>> dialog = new Dialog<>();
		dialog.setTitle("Login Dialog");
		dialog.setHeaderText("Look, a Custom Login Dialog");

		// Set the icon (must be included in the project).
		// dialog.setGraphic(new
		// ImageView(this.getClass().getResource("d://AKN//myProductImages//logo.png").toString()));

		// Set the button types.
		ButtonType loginButtonType = new ButtonType("Login", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		// Create the username and password labels and fields.
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		JFXTextField username = new JFXTextField();
		username.setPromptText("Username");
		JFXPasswordField password = new JFXPasswordField();
		password.setPromptText("Password");

		grid.add(new Label("Username:"), 0, 0);
		grid.add(username, 1, 0);
		grid.add(new Label("Password:"), 0, 1);
		grid.add(password, 1, 1);

		// Enable/Disable login button depending on whether a username was
		// entered.
		Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(true);

		// Do some validation (using the Java 8 lambda syntax).
		username.textProperty().addListener((observable, oldValue, newValue) -> {
			loginButton.setDisable(newValue.trim().isEmpty());
		});

		dialog.getDialogPane().setContent(grid);

		// Request focus on the username field by default.
		Platform.runLater(() -> username.requestFocus());

		// Convert the result to a username-password-pair when the login button
		// is clicked.
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == loginButtonType) {
				return new Pair<>(username.getText(), password.getText());
			}
			return null;
		});

		Optional<Pair<String, String>> result = dialog.showAndWait();

		result.ifPresent(usernamePassword -> {
			System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
		});
	}

}// Last
