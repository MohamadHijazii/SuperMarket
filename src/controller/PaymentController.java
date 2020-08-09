package controller;

import java.net.URL;
import java.util.Date;
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
import model.Payment;

public class PaymentController implements Initializable {
	
	@FXML
    private TableView<Payment> tb;

    @FXML
    private TableColumn<Payment, Integer> nb;

    @FXML
    private TableColumn<Payment, String> check;

    @FXML
    private TableColumn<Payment, Date> date;

    @FXML
    private TableColumn<Payment, Double> amount;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		nb.setCellValueFactory(new PropertyValueFactory<Payment, Integer>("customerNumber"));
		check.setCellValueFactory(new PropertyValueFactory<Payment, String>("checkNumber"));
		date.setCellValueFactory(new PropertyValueFactory<Payment, Date>("paymentDate"));
		amount.setCellValueFactory(new PropertyValueFactory<Payment, Double>("amount"));
		
		tb.getItems().addAll(setListFromR());
	}
	
	
	ObservableList<Payment> setListFromR() {
		DB db = DB.getInstance();
		ObservableList<Payment> ol = FXCollections.observableArrayList();
		for(Payment c : db.payments) {
			ol.add(c);
		}
		return ol;
	}

}
