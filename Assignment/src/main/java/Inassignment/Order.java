package Inassignment;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Order {

	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "order_seq")
	@SequenceGenerator(name = "order_seq", sequenceName = "order_seq", allocationSize = 1)
	private int id;
	private int customer_id;///////
	@OneToMany(mappedBy = "order")
	private Set<LineItem> lineItems;
	
	
	public Order() {}
	
	
	public Order(int id, int customer_id, Set<LineItem> lineItems) {
		super();
		this.id = id;
		this.customer_id = customer_id;
		this.lineItems = lineItems;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public Set<LineItem> getLineItems() {
		return lineItems;
	}
	public void setLineItems(Set<LineItem> lineItems) {
		this.lineItems = lineItems;
	}


	@Override
	public String toString() {
		return "Order [id=" + id + ", customer_id=" + customer_id + ", lineItems=" + lineItems + "]";
	}
	
	
	
	
	
	
}
