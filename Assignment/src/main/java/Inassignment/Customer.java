package Inassignment;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Customer {

	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "customer_seq")
	@SequenceGenerator(name="customer_seq",sequenceName = "customer_seq", allocationSize = 1)
	private long id;
	private String name;
	private int age;
	private String address; 
	private String p_address;
	
	@OneToMany(targetEntity = Order.class,fetch = FetchType.LAZY, mappedBy = "customer")
	private Set<Order> order;
	
	public Set<Order> getOrder(){
		return order;
	}
	
	public void setOrder(Set<Order> order) {
		this.order=order;
	}
	
	
	
	public Customer() {}
	
	public Customer(long id, String name, int age, String address, String p_address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.p_address = p_address;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getP_address() {
		return p_address;
	}
	public void setP_address(String p_address) {
		this.p_address = p_address;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", p_address="
				+ p_address + "]";
	}
	
	
	
	
}
