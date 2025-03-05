package Inassignment;

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
import javax.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderseq")
    @SequenceGenerator(name = "orderseq", sequenceName = "order_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(targetEntity = Customer.class,cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;

    private String orderStatus;

    @OneToMany( mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderItem> orderItems;

    public Orders() {}

    public Orders(Customer customer, String orderStatus, Set<OrderItem> orderItems) {
        this.customer = customer;
        this.orderStatus = orderStatus;
        this.orderItems = orderItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
    
    public void addOrderItems(OrderItem ob) {
    	if(orderItems==null) orderItems= new HashSet<OrderItem>();
    	orderItems.add(ob);
    }
    
    public void removeOrderItems(OrderItem ob) {
    	orderItems.remove(ob);
    }
}
