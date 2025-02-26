package Inassignment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class LineItem {

	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "lineitem_seq")
	@SequenceGenerator(name = "lineitem_seq", sequenceName = "lineitem_seq", allocationSize = 1)
	private long id;
	
	@ManyToOne
	private Item item;
	private int quantity;
	@ManyToOne
	private Order order;
	
	public LineItem() {}
	
	public LineItem(long id, Item item, int quantity, Order order) {
		super();
		this.id = id;
		this.item = item;
		this.quantity = quantity;
		this.order = order;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "LineItem [id=" + id + ", item=" + item + ", quantity=" + quantity + ", order=" + order + "]";
	}
	
	
	
}
