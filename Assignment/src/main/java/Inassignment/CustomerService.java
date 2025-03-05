package Inassignment;
import java.util.List;
import java.util.Set;

public interface CustomerService {
    void save(Customer customer); 
    void update(Customer c);
    void delete(Long customerId);   
    Customer get(Long customerId);  
    Set<Customer> findAll();  
}
