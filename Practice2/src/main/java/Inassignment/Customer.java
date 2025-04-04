package Inassignment;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {
	
    @Id@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerseq")
    @SequenceGenerator(name = "customerseq", sequenceName = "customer_seq", allocationSize = 1)
    private Long id;

    private String name;
    private int age;
    private String address;
    private String permanentAddress;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Orders> orders;

    public Customer() {}

    public Customer(String name, int age, String address, String permanentAddress) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.permanentAddress = permanentAddress;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }
}
