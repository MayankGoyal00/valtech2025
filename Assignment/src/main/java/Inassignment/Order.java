package Inassignment;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Order {

	public enum order_status{
		DELIVERED,PENDING,PROCESSING;
	}
	@Id
	private long id;
	private String get_line_item;
	private order_status order_status;
	
	
	@ManyToOne()
	private Set<LineItem> lineorderitem; 
	
	public void setLineorderitem(Set<LineItem> lineorderitem) {
		this.lineorderitem = lineorderitem;
	}
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = Customer.class)
	@JoinColumn(name="cust_id",referencedColumnName = "cust_id")
	private Customer customer;
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	public Order() {}
	
	
	public Order(int id, int customer_id, Set<LineItem> lineItems) {
		super();
		this.id = id;
		this.customer_id = customer_id;
		this.lineItems = lineItems;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
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
