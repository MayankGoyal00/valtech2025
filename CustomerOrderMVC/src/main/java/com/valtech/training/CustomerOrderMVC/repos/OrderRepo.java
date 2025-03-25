package com.valtech.training.CustomerOrderMVC.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.CustomerOrderMVC.entities.Order;

@Repository
public interface OrderRepo  extends JpaRepository<Order, Integer>{

}
