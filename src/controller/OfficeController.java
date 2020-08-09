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
import model.Office;

public class OfficeController implements Initializable{
	
	 @FXML
	    private TableView<Office> tb;

	    @FXML
	    private TableColumn<Office, String> code;

	    @FXML
	    private TableColumn<Office, String> city;

	    @FXML
	    private TableColumn<Office,String> phone;

	    @FXML
	    private TableColumn<Office, String> ad1;

	    @FXML
	    private TableColumn<Office, String> ad2;

	    @FXML
	    private TableColumn<Office, String> state;

	    @FXML
	    private TableColumn<Office, String> country;

	    @FXML
	    private TableColumn<Office, String> postal;

	    @FXML
	    private TableColumn<Office, String> terr;

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			code.setCellValueFactory(new PropertyValueFactory<Office, String>("officeCode"));
			city.setCellValueFactory(new PropertyValueFactory<Office, String>("city"));
			phone.setCellValueFactory(new PropertyValueFactory<Office, String>("phone"));
			ad1.setCellValueFactory(new PropertyValueFactory<Office, String>("addressLine1"));
			ad2.setCellValueFactory(new PropertyValueFactory<Office, String>("addressLine2"));
			state.setCellValueFactory(new PropertyValueFactory<Office, String>("state"));
			country.setCellValueFactory(new PropertyValueFactory<Office, String>("country"));
			postal.setCellValueFactory(new PropertyValueFactory<Office, String>("postalCode"));
			terr.setCellValueFactory(new PropertyValueFactory<Office, String>("territory"));
			tb.getItems().addAll(setListFromR());
			
		}

		ObservableList<Office> setListFromR() {
			DB db = DB.getInstance();
			ObservableList<Office> ol = FXCollections.observableArrayList();
			for(Office c : db.offices) {
				ol.add(c);
			}
			return ol;
		}
}
