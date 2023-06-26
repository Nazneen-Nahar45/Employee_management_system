package application;


import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lib.DataHandler;
import lib.Employee;

public class empdetailsController 
{
	@FXML
	private TextField anempid;
	@FXML
	private TextArea empdetailarea;

	public void OK(ActionEvent event) throws IOException {
		String id = anempid.getText();

		// Load the company data from file
		DataHandler.loadData();

		// Iterate over the list of employees to find the one with the given ID
		ArrayList<Employee> employees = Main.myCom.getEmployees();
		String employeeInfo = "";
		for (Employee employee : employees) {
			if (employee.getId().equals(id)) {
				employeeInfo = employee.toString();
				break;
			}
		}

		//     Display the employee information or a message if no employee is found
		if (employeeInfo.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No Employee found by given id\n");
			
			empdetailarea.setText("");
			return ;
		} else {
			
			empdetailarea.setText(employeeInfo);
		}

	}


	public void Exit(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("adminmenu.fxml"));
		Scene scene = new Scene(root);

		Main.stage.setScene(scene);
		Main.stage.show();
	}

}