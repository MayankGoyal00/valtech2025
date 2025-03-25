package com.valtech.training.CustomerOrderMVC.services;
import java.util.List;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.valtech.training.CustomerOrderMVC.entities.Customer;
import com.valtech.training.CustomerOrderMVC.vos.CustomerVO;

@SpringBootApplication
public interface CustomerService {
	CustomerVO saveCustomer(CustomerVO cvo);
	CustomerVO updateCustomer(int id, CustomerVO cvo);
	CustomerVO getCustomer(int id);
	List<CustomerVO> getAllCustomer();
}





