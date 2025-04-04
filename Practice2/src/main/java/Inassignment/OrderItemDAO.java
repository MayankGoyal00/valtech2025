package Inassignment;

import java.util.List;
import java.util.Set;

public interface OrderItemDAO {
    
    void save(OrderItem oi); 
    void update(OrderItem oi);
    void delete(Long oiId);   
    OrderItem get(Long oiId);  
    List<OrderItem> getAll();
}
