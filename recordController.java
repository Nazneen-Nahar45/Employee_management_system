package application;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lib.Company;
import lib.DailyRecord;
import lib.DataHandler;
import lib.Employee;
import lib.InvalidEmployeeException;

public class recordController implements Initializable {
    
    @FXML
    private TextField employeeIdTextField;
    
    @FXML
    private Button searchButton;
    
    @FXML
    private TextArea dailyRecordTextArea;
    
    private Company company;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        company = DataHandler.loadData();
    }
    
    @FXML
    private void searchButtonAction(ActionEvent event) {
        String employeeId = employeeIdTextField.getText();
        try {
            Employee employee = company.findEmployee(employeeId);
            ArrayList<DailyRecord> dailyRecords = company.getDailyRecords(employeeId);
            String recordData = "";
            for (DailyRecord record : dailyRecords) {
                recordData += record.toString() + "\n";
            }
            dailyRecordTextArea.setText(recordData);
        } catch (InvalidEmployeeException e) {
            dailyRecordTextArea.setText("Employee not found.");
        }
    }
    
    public void Exit(ActionEvent e) throws IOException 
	{
		Parent root = FXMLLoader.load(getClass().getResource("adminmenu.fxml"));
		Scene scene = new Scene(root);

		Main.stage.setScene(scene);
		Main.stage.show();
	}
    
}