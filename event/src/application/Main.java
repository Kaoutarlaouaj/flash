package application;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.control.*;

public class Main extends Application {
	    private TextField tx1;
	    private TextField tx2;
	    private TextField tx3;
	    private TextField tx4;
	    private TextField tx5;
	    private Label l1;
	    private Label l2;
	    private Label l3;
	    private Label l4;
	    private Label l5;
@Override
public void start(Stage PrimaryStage)
{
	
	try
	{
		PrimaryStage.setTitle("Loan Calculator");
		l1 = new Label("Taux d’intérêt Annuel:");
		tx1 = new TextField();
	    l2 = new Label("Durée en année:");
		tx2 = new TextField();
		l3 = new Label("Montant crédit:");
		 tx3 = new TextField();
		l4 = new Label("Paiement mensuel:");
		 tx4 = new TextField();
		 l5 = new Label("Total Paiement:");
		tx5 = new TextField();
		Button Calculate = new Button("Calculate");
		Calculate.setOnAction(event -> {
			 double amount = Double.parseDouble(tx3.getText());
	         double interestRate = Double.parseDouble(tx1.getText());
	         int years = Integer.parseInt(tx2.getText());
	         int months = years * 12;
	         double monthlyInterestRate = interestRate / 1200;
	         double denominator = 1 - Math.pow(1 + monthlyInterestRate, -months);
	         double monthlyPayment = (amount * monthlyInterestRate) / denominator;
	         double totalPayment = monthlyPayment * months;
	            
	            tx4.setText(String.format("%.2f Dhs", monthlyPayment));
	            tx5.setText(String.format("%.2f Dhs", totalPayment));
		});
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.setHgap(10);
		root.setVgap(15);
		root.setPadding(new Insets(25,25,25,25));
		root.add(l1, 0, 0);
		root.add(tx1,1, 0);
		root.add(l2, 0, 1);
		root.add(tx2, 1, 1);
		root.add(l3, 0, 2);
		root.add(tx3, 1, 2);
		root.add(l4, 0, 3);
		root.add(tx4, 1, 3);
		root.add(l5, 0, 4);
		root.add(tx5, 1, 4);
		root.add(Calculate, 1, 5);
		Scene scene = new Scene(root,400,400);
		PrimaryStage.setScene(scene);
		PrimaryStage.show();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

public static void main(String[] args)
{
	launch(args);
}
}

































/*
package application;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.*;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Main extends Application {
	private Circle circle;
    private final int initialDiameter = 100;
    private final int step = 10;
@Override

public void start (Stage PrimaryStage)
{
	try {
		circle = new Circle(initialDiameter / 2, initialDiameter / 2, initialDiameter / 2, Color.GREEN);
        circle.setStroke(Color.BLACK);
		Button Enlarge = new Button("Enlarge");
		Button Shrink = new Button("Shirnk");
		Enlarge.addEventHandler(ActionEvent.ACTION,event -> Enlarge());
		Shrink.addEventHandler(ActionEvent.ACTION,event -> Shrink());
		HBox hb = new HBox();
		hb.getChildren().addAll(Enlarge,Shrink);
		 // Création du layout
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));
        root.add(circle,1,0);
        root.add(hb,1,2);
		Scene scene = new Scene(root,400,400);
		PrimaryStage.setScene(scene);
		PrimaryStage.show();
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}



private void Enlarge()
{
	double newDiameter = circle.getRadius() * 2 + step;
    circle.setRadius(newDiameter / 2);
} 

private void Shrink()
{
	double newDiameter = circle.getRadius() * 2 - step;
    if (newDiameter > 0) {
        circle.setRadius(newDiameter / 2);
    }
}

public static void main(String[] args)
{
	launch(args);
}

}


*/

























/*
package application;
	
import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.Random;


public class Main extends Application {
	Random rd = new Random();
	TextArea Tx = new TextArea();
	@Override
	
	public void start(Stage primaryStage) {
		try {
			Button Insert = new Button("Insert");
			Button Delete = new Button("Delete");
			Button Quit = new Button("Quit");
			Button Alert = new Button("Alert");
			Insert.setOnAction(event -> {
				char c = genereterandom();
				Tx.appendText(String.valueOf(c));
			});
			Delete.setOnAction(event -> {
				int L = Tx.getText().length();
				if (L>0)
				{
					Tx.deleteText(L-1,L);
				}
			} 
			);
			Quit.setOnAction(event ->{
				int L = Tx.getText().length();
				if (L>0)
				{
					Tx.deleteText(0, L);
				}
			});
			Alert.setOnAction(event -> {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setContentText(Tx.getText());
				alert.showAndWait();
			});
			VBox vb = new VBox();
			HBox hb = new HBox();
			hb.getChildren().addAll(Insert,Delete,Quit,Alert);
			vb.getChildren().addAll(Tx,hb);
			Scene scene = new Scene(vb,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private char genereterandom()
	{
		int randomInt = rd.nextInt(62);
		if(randomInt<26)
		{
			return (char) ('A' + randomInt);
		}
		else if(randomInt<52)
		{
			return (char) ('a' + randomInt-26);
		}
		else
		{
			return (char) ('0' + randomInt-52);
		}
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
*/