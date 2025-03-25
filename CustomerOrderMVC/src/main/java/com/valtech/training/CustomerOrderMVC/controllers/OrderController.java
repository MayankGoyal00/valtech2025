package com.valtech.training.CustomerOrderMVC.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.CustomerOrderMVC.services.CustomerService;
import com.valtech.training.CustomerOrderMVC.services.OrderService;
import com.valtech.training.CustomerOrderMVC.vos.CustomerVO;
import com.valtech.training.CustomerOrderMVC.vos.OrderVO;

@RestController
@RequestMapping("/api/customers")
public class OrderController {
 
    @Autowired
    private OrderService orderService;
 
  
    @PostMapping
    public OrderVO saveOrder(@RequestBody OrderVO orderVO) {
        return orderService.placeOrder(orderVO);
    }
 
    @GetMapping("/{id}")
    public OrderVO getOrder(@PathVariable int id) {
        return orderService.getOrderById(id);
    }
 
    
    @GetMapping
    public List<OrderVO> getAllOrders() {
        return orderService.getAllOrders();
    }
}