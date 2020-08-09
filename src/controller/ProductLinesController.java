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
import model.Productlines;

public class ProductLinesController implements Initializable{

	  	@FXML
	    private TableView<Productlines> tb;

	    @FXML
	    private TableColumn<Productlines, String> line;

	    @FXML
	    private TableColumn<Productlines, String> desc;

	    @FXML
	    private TableColumn<Productlines, String> html;

	    @FXML
	    private TableColumn<Productlines, String> blob;

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			line.setCellValueFactory(new PropertyValueFactory<Productlines, String>("productLine"));
			desc.setCellValueFactory(new PropertyValueFactory<Productlines, String>("textDescription"));
			html.setCellValueFactory(new PropertyValueFactory<Productlines, String>("htmlDescription"));
			blob.setCellValueFactory(new PropertyValueFactory<Productlines, String>("mediumblob"));
			
			tb.getItems().setAll(setListFromR());
			
		}
		
		ObservableList<Productlines> setListFromR() {
			DB db = DB.getInstance();
			ObservableList<Productlines> ol = FXCollections.observableArrayList();
			for(Productlines c : db.productLines) {
				ol.add(c);
			}
			return ol;
		}
}
