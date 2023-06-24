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
import lib.Company;
import lib.DataHandler;
import lib.Employee;

public class DetailsOfEmployeeController 
{
	@FXML
	private TextField idField;
	@FXML
	private TextField nameField;
	@FXML
	private TextField ageField;
	@FXML
	private TextField desField;
	@FXML
	private TextField phoneField;
	@FXML
	private TextField salField;

	public void searchEmployee() throws IOException 
	{
		String employeeId = idField.getText();

		Company company = DataHandler.loadData();
		ArrayList<Employee> employees = company.getEmployees();

		boolean found = false;
		for (Employee employee : employees) 
		{
			if (employee.getId().equals(employeeId)) 
			{
				nameField.setText(employee.getName());
				ageField.setText(Integer.toString(employee.getAge()));
				desField.setText(employee.getDesignation());
				phoneField.setText(employee.getPhoneNum());
				salField.setText(Double.toString(employee.getSalary()));
				found = true;
				break;
			}
		}

		if (!found) 
		{
			JOptionPane.showMessageDialog(null, ("Sorry! Could not find employee with ID : " + employeeId));
			return;
		}
	}
	public void EXIT(ActionEvent e) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("EmployeeLogIn.fxml"));
		Scene scene = new Scene(root);

		Main.stage.setScene(scene);
		Main.stage.show();
	}
}