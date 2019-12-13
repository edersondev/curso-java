package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.OrderStatus;

public class Order {
	private Date moment;
	private OrderStatus status;
	
	private List<OrderItem> items = new ArrayList<>();
	
	private Client client;

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public void addItem(OrderItem item) {
		this.items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		this.items.remove(item);
	}
	
	public Double total() {
		double sum = 0.0;
		for(OrderItem item : items) {
			sum += item.subTotal();
		}
		return sum;
	}
}
