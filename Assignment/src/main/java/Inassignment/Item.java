package Inassignment;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemseq")
    @SequenceGenerator(name = "itemseq", sequenceName = "item_seq", allocationSize = 1)
    private Long id;

    private String name;
    private String description;
    private int currentQuantity;
    private int reorderQuantity;
    private int maxQuantity;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private Set<OrderItem> orderItems;

    public Item() {}

    public Item(String name, String description, int currentQuantity, int reorderQuantity, int maxQuantity) {
        this.name = name;
        this.description = description;
        this.currentQuantity = currentQuantity;
        this.reorderQuantity = reorderQuantity;
        this.maxQuantity = maxQuantity;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public int getReorderQuantity() {
        return reorderQuantity;
    }

    public void setReorderQuantity(int reorderQuantity) {
        this.reorderQuantity = reorderQuantity;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
