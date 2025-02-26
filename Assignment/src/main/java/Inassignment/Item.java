package Inassignment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Item {
	
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "item_seq")
	@SequenceGenerator(name = "item_seq", sequenceName = "item_seq", allocationSize = 1)
	private int id;
	private String name;
	private String description;
	private int quantity;
	private int reorder_level;
	private int max_quantity;
	
	public Item() {}
	
	public Item(int id, String name, String description, int quantity, int reorder_level, int max_quantity) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.reorder_level = reorder_level;
		this.max_quantity = max_quantity;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getReorder_level() {
		return reorder_level;
	}
	public void setReorder_level(int reorder_level) {
		this.reorder_level = reorder_level;
	}
	public int getMax_quantity() {
		return max_quantity;
	}
	public void setMax_quantity(int max_quantity) {
		this.max_quantity = max_quantity;
	}

	
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", quantity=" + quantity
				+ ", reorder_level=" + reorder_level + ", max_quantity=" + max_quantity + "]";
	}
	
	

}
