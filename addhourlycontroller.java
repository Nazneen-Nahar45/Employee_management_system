package application;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lib.Company;
import lib.DataHandler;
import lib.Employee;

public class addhourlycontroller implements Initializable 
{
	@FXML
	TextArea taa22;
	@FXML
	TextField name22;
	@FXML
	TextField age22;
	@FXML
	TextField des22;
	@FXML
	TextField phn22;
	@FXML
	TextField sal22;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		Company com = new Company("UAP");
		ArrayList<Employee> employees = Main.myCom.getEmployees();

		String data ="";
		for(Employee e : employees)
			data += e .toString()+"\n";

		if(employees.size()==0) 
		{
			DataHandler.saveData(com);
		}
		taa22.setText(data);
	}
	public void addH(ActionEvent event) {
		String name1 = name22.getText();
		String age1 = age22.getText();
		String desig = des22.getText();
		String phnNo = phn22.getText();
		String salary = sal22.getText();
		
		int Age;
		double Salary;
		boolean b1=false ;
		boolean b2=false ;
		
		if (name1.isEmpty() || age1.isEmpty() || desig.isEmpty() || phnNo.isEmpty() || salary.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields.");
            return;
        }

		try {
			Age =Integer.parseInt(age1);
			b1=true;
		}
		catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(null,"Age must be number!" );
			return;
		}
		try {
			Salary =Double.parseDouble(salary);
			b2=true;
		}
		catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(null,"Salary must be Double!" );
			return;
		}

		if(b1&&b2) {
			String id = Main.myCom.addHourlyEmployee(name1, Integer.parseInt(age1), desig, phnNo, Double.parseDouble(salary));
			System.out.println(Main.myCom.getEmployees().size());

			DataHandler.saveData(Main.myCom);
			JOptionPane.showMessageDialog(null, id + " Successfully Added!");
			initialize(null,null);
		}
	}

	public void exit(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("addpage.fxml"));
		Scene scene = new Scene(root);

		Main.stage.setScene(scene);
		Main.stage.show();
	}
}
