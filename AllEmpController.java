package application;


import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import lib.DataHandler;
import lib.Employee;

public class AllEmpController {
	@FXML
	private TextArea allempdetailarea ;
	@FXML 
	public void Display(ActionEvent e) throws IOException {

		ArrayList<Employee> employees = DataHandler.loadData().getEmployees();
		String data = "";

		for (Employee e2 : employees)
			data += e2.toString() + "\n";

		if (employees.size() == 0) {
			data = "No Employee Available";
		}

		allempdetailarea.setText(data);
	}
	public void Exit(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("adminmenu.fxml"));
		Scene scene = new Scene(root);

		Main.stage.setScene(scene);
		Main.stage.show();
	}

}