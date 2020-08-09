package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;
import model.DB;

public class CustomerController implements Initializable{
	
	@FXML
    private TableView<Customer> tb;

    @FXML
    private TableColumn<Customer, Integer> nb;

    @FXML
    private TableColumn<Customer, String> name;

    @FXML
    private TableColumn<Customer, String> lname;

    @FXML
    private TableColumn<Customer, String> fname;

    @FXML
    private TableColumn<Customer, String> phone;

    @FXML
    private TableColumn<Customer, String> ad1;

    @FXML
    private TableColumn<Customer, String> ad2;

    @FXML
    private TableColumn<Customer, String> city;

    @FXML
    private TableColumn<Customer, String> state;

    @FXML
    private TableColumn<Customer, String> pcode;

    @FXML
    private TableColumn<Customer, String> country;

    @FXML
    private TableColumn<Customer, Integer> sales;

    @FXML
    private TableColumn<Customer, Double> credit;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<Customer> ol = setListFromR();
		nb.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("customerNumber"));
		name.setCellValueFactory(new PropertyValueFactory<Customer, String>("customerName"));
		lname.setCellValueFactory(new PropertyValueFactory<Customer, String>("contactLastName"));
		fname.setCellValueFactory(new PropertyValueFactory<Customer, String>("contactFirstName"));
		phone.setCellValueFactory(new PropertyValueFactory<Customer, String>("phone"));
		ad1.setCellValueFactory(new PropertyValueFactory<Customer, String>("addressLine1"));
		ad2.setCellValueFactory(new PropertyValueFactory<Customer, String>("addressLine2"));
		city.setCellValueFactory(new PropertyValueFactory<Customer, String>("city"));
		state.setCellValueFactory(new PropertyValueFactory<Customer, String>("state"));
		pcode.setCellValueFactory(new PropertyValueFactory<Customer, String>("postalCode"));
		country.setCellValueFactory(new PropertyValueFactory<Customer, String>("country"));
		sales.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("salesRepEmployeeNumber"));
		credit.setCellValueFactory(new PropertyValueFactory<Customer, Double>("creditLimit"));
		tb.getItems().setAll(ol);
		
	}
    
	ObservableList<Customer> setListFromR() {
		DB db = DB.getInstance();
		ObservableList<Customer> ol = FXCollections.observableArrayList();
		for(Customer c : db.customers) {
			ol.add(c);
		}
		return ol;
	}
	
	void setListFromO() {
		
	}
    

}
