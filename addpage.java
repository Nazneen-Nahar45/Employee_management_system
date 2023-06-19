package application;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class addpage {



	public void salaried(ActionEvent e) throws IOException 
	{
		Parent root = FXMLLoader.load(getClass().getResource("addhourly.fxml"));
		Scene scene = new Scene(root);

		Main.stage.setScene(scene);
		Main.stage.show();
	}



	public void hourly(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("addhourly.fxml"));
		Scene scene = new Scene(root);

		Main.stage.setScene(scene);
		Main.stage.show();
	}



	public void commission(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("addcommission.fxml"));
		Scene scene = new Scene(root);

		Main.stage.setScene(scene);
		Main.stage.show();
	}




	public void exit(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("adminmenu.fxml"));
		Scene scene = new Scene(root);

		Main.stage.setScene(scene);
		Main.stage.show();
	}




}
