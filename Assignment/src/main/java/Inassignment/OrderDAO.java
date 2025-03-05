package Inassignment;
import java.util.List;
import java.util.Set;

public interface OrderDAO {
    void save(Orders o); 
    void update(Orders oo);
    void delete(Long orderId);   
    Orders get(Long orderId);  
    Set<Orders> findAll();
	
	
}
