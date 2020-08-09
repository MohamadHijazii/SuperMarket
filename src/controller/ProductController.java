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
import model.Product;

public class ProductController implements Initializable{
	
	@FXML
    private TableView<Product> tb;

    @FXML
    private TableColumn<Product, String> code;

    @FXML
    private TableColumn<Product, String> name;

    @FXML
    private TableColumn<Product, String> line;

    @FXML
    private TableColumn<Product, String> scale;

    @FXML
    private TableColumn<Product, String> vendor;

    @FXML
    private TableColumn<Product, String> desc;

    @FXML
    private TableColumn<Product, Integer> qt;

    @FXML
    private TableColumn<Product, Double> price;

    @FXML
    private TableColumn<Product, Double> msrp;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		code.setCellValueFactory(new PropertyValueFactory<Product, String>("productCode"));
		name.setCellValueFactory(new PropertyValueFactory<Product, String>("productName"));
		line.setCellValueFactory(new PropertyValueFactory<Product, String>("productLines"));
		scale.setCellValueFactory(new PropertyValueFactory<Product, String>("productScale"));
		vendor.setCellValueFactory(new PropertyValueFactory<Product, String>("productVendor"));
		desc.setCellValueFactory(new PropertyValueFactory<Product, String>("productDescription"));
		qt.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantityInStock"));
		price.setCellValueFactory(new PropertyValueFactory<Product, Double>("buyPrice"));
		msrp.setCellValueFactory(new PropertyValueFactory<Product, Double>("MSRP"));
		tb.getItems().addAll(setListFromR());
		
	}
	
	ObservableList<Product> setListFromR() {
		DB db = DB.getInstance();
		ObservableList<Product> ol = FXCollections.observableArrayList();
		for(Product c : db.products) {
			ol.add(c);
		}
		return ol;
	}

}
