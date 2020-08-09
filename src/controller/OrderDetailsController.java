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
import model.OrderDetails;

public class OrderDetailsController implements Initializable{
	@FXML
    private TableView<OrderDetails> tb;

    @FXML
    private TableColumn<OrderDetails, Integer> nb;

    @FXML
    private TableColumn<OrderDetails, String> code;

    @FXML
    private TableColumn<OrderDetails, Integer> qt;

    @FXML
    private TableColumn<OrderDetails, Double> price;

    @FXML
    private TableColumn<OrderDetails, String> oline;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		nb.setCellValueFactory(new PropertyValueFactory<OrderDetails, Integer>("orderNumber"));
		code.setCellValueFactory(new PropertyValueFactory<OrderDetails, String>("productCode"));
		qt.setCellValueFactory(new PropertyValueFactory<OrderDetails, Integer>("quantityOrdered"));
		price.setCellValueFactory(new PropertyValueFactory<OrderDetails, Double>("priceEach"));
		oline.setCellValueFactory(new PropertyValueFactory<OrderDetails, String>("orderLineNumber"));
		
		tb.getItems().addAll(setListFromR());
	}
	
	ObservableList<OrderDetails> setListFromR() {
		DB db = DB.getInstance();
		ObservableList<OrderDetails> ol = FXCollections.observableArrayList();
		for(OrderDetails c : db.orderDetails) {
			ol.add(c);
		}
		return ol;
	}

}
