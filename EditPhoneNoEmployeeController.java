package application;


import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import lib.DataHandler;
import lib.Employee;

public class EditPhoneNoEmployeeController 
{

//	@FXML
//	private TextField idField;

	@FXML
	private TextField phoneField;
	private TextInputControl enteremployeeid;

	@FXML
	private void editPhoneNo() throws IOException 
	{   

		//String id = idField.getText();
		String phone = phoneField.getText();

		if ( phone.isEmpty()) 
		{
			JOptionPane.showMessageDialog(null, "Please Enter ID and New Phone Number!");
			return;
		}

		// Load the company data from the file
		DataHandler.loadData();

		// Get the list of employees
		ArrayList<Employee> employees = Main.myCom.getEmployees();

		
		// Loop through the list of employees and find the employee with the matching ID
		for (Employee e : employees) 
		{
//			if (e.getId().equals(id)) 
//			{    
				// Update the employee's phone number
			
				e.setPhoneNum(phone);
				JOptionPane.showMessageDialog(null, "Phone Number Updated Successfully!");

				// Save the updated company data to the file
				DataHandler.saveData(Main.myCom);
				return;
			
		}

		// If the loop completes without finding an employee with the given ID
		//JOptionPane.showMessageDialog(null, ("No employee found with ID: " + id));
		return;
	}
	public void EXIT(ActionEvent e) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("EmployeeLogIn.fxml"));
		Scene scene = new Scene(root);

		Main.stage.setScene(scene);
		Main.stage.show();
	}
}