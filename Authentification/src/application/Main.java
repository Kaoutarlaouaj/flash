package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// le titre d'un stage :
			primaryStage.setTitle("Authentification");
			// Création du layout pour la fenêtre :
			GridPane gridPane = new GridPane();
			// Création des contrôles
		    Label label1 = new Label("User Name: ");
		    label1.setStyle("-fx-font-size: 14pt; -fx-text-fill: #333;");
		    TextField textField1 = new TextField();
		    textField1.setStyle("-fx-font-size: 14pt;");
		    Label label2 = new Label("Password: ");
		    label2.setStyle("-fx-font-size: 14pt; -fx-text-fill: #333;");
		    TextField textField2 = new TextField();
		    textField2.setStyle("-fx-font-size: 14pt;");
		    Text authText = new Text();
		    Button button = new Button("Sign in");
		    button.setStyle("-fx-font-size: 14pt; -fx-background-color: #4CAF50; -fx-text-fill: white;");
		    // un événement au bouton : 
		    button.setOnAction(event -> {
		    	// Récupérer les deux champs login et password : 
	            String userName = textField1.getText();
	            String password = textField2.getText();
	            if (userName.equals("admin") && password.equals("admin")) {
	                authText.setFill(Color.GREEN);
	                authText.setText("Authentication succeeded!");
	            } else {
	                authText.setFill(Color.RED);
	                authText.setText("Authentication failed!");
	            }
	        });
	        gridPane.setAlignment(Pos.CENTER);
	        gridPane.setHgap(10);
	        gridPane.setVgap(10);
	        gridPane.setPadding(new Insets(25, 25, 25, 25));
	        gridPane.add(label1, 0, 0);
	        gridPane.add(textField1, 1, 0);
	        gridPane.add(label2, 0, 1);
	        gridPane.add(textField2, 1, 1);
	        gridPane.add(button, 1, 2);
	        gridPane.add(authText, 1, 3);
			primaryStage.setScene(new Scene(gridPane,400, 400));
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
