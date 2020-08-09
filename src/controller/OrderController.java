package controller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javax.persistence.criteria.CriteriaBuilder.In;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;
import model.DB;
import model.Order;

public class OrderController implements Initializable{
	@FXML
    private TableView<Order> tb;

    @FXML
    private TableColumn<Order, Integer> nb;

    @FXML
    private TableColumn<Order, Date> odate;

    @FXML
    private TableColumn<Order, Date> rdate;

    @FXML
    private TableColumn<Order, Date> sdate;

    @FXML
    private TableColumn<Order, String> status;

    @FXML
    private TableColumn<Order, String> comments;

    @FXML
    private TableColumn<Order, Integer> cnb;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		nb.setCellValueFactory(new PropertyValueFactory<Order,Integer>("orderNumber"));
		odate.setCellValueFactory(new PropertyValueFactory<Order,Date>("orderDate"));
		rdate.setCellValueFactory(new PropertyValueFactory<Order,Date>("requiredDate"));
		sdate.setCellValueFactory(new PropertyValueFactory<Order,Date>("shippedDate"));
		status.setCellValueFactory(new PropertyValueFactory<Order,String>("status"));
		comments.setCellValueFactory(new PropertyValueFactory<Order,String>("comments"));
		cnb.setCellValueFactory(new PropertyValueFactory<Order,Integer>("customerNumber"));
		tb.getItems().addAll(setListFromR());
	}

	
	ObservableList<Order> setListFromR() {
		DB db = DB.getInstance();
		ObservableList<Order> ol = FXCollections.observableArrayList();
		for(Order c : db.orders) {
			ol.add(c);
		}
		return ol;
	}
	
}
