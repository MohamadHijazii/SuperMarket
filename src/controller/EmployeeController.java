package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;
import model.DB;
import model.Employee;

public class EmployeeController implements Initializable{

	
	@FXML
    private TableView<Employee> tb;

    @FXML
    private TableColumn<Employee, Integer> nb;

    @FXML
    private TableColumn<Employee, String> lname;

    @FXML
    private TableColumn<Employee, String> fname;

    @FXML
    private TableColumn<Employee, String> ex;

    @FXML
    private TableColumn<Employee, String> email;

    @FXML
    private TableColumn<Employee, String> ocode;

    @FXML
    private TableColumn<Employee,Integer> report;

    @FXML
    private TableColumn<Employee, String> job;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<Employee> ol= setListFromR();
		nb.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("employeeNumber"));
		lname.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));
		fname.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstName"));
		ex.setCellValueFactory(new PropertyValueFactory<Employee, String>("extension"));
		email.setCellValueFactory(new PropertyValueFactory<Employee, String>("email"));
		ocode.setCellValueFactory(new PropertyValueFactory<Employee, String>("officeCode"));
		report.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("reportsTo"));
		job.setCellValueFactory(new PropertyValueFactory<Employee, String>("jobTitle"));
		tb.getItems().setAll(ol);
		
	}
	
	ObservableList<Employee> setListFromR() {
		DB db = DB.getInstance();
		ObservableList<Employee> ol = FXCollections.observableArrayList();
		for(Employee c : db.employees) {
			ol.add(c);
		}
		return ol;
	}
}
