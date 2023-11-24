package application;
import javafx.application.*;
import javafx.geometry.Insets;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
public class Main extends Application {
	public void start (Stage primarystage)
	{ 
		Stage window = primarystage;
		window.setTitle("first application");
		Button bt = new Button("Sign in");
		Label l = new Label("Welcome");
		TextField tf1 = new TextField();
		TextField tf2 = new TextField();
		Label l1 = new Label("username : ");
		Label l2 = new Label("password : ");
		GridPane gridPane = new GridPane();
		gridPane.setHgap(8); // Définit l'espacement horizontal entre les colonnes
		gridPane.setVgap(10); // Définit l'espacement vertical entre les lignes
		gridPane.setPadding(new Insets(10,10,10,10)); // Définit les marges autour de la grille
		GridPane.setConstraints(l1, 0, 0);
		GridPane.setConstraints(tf1, 1, 0);
		GridPane.setConstraints(l2, 0, 1);
		GridPane.setConstraints(tf2, 1, 1);
		GridPane.setConstraints(bt, 1,2);
        gridPane.getChildren().addAll(l1,tf1,l2,tf2,bt);
		Scene scene = new Scene(gridPane, 400, 400);
		window.setScene(scene);
		window.show();
	}
}