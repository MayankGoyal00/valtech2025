package com.valtech.training.CustomerOrderMVC.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.CustomerOrderMVC.services.CustomerService;
import com.valtech.training.CustomerOrderMVC.vos.CustomerVO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomerController {
 
    @Autowired
    private CustomerService customerService;
 
  
    @RequestMapping("/customer")
    public String customer(HttpServletRequest req) {
    	return "customer";
    }
    
    @RequestMapping(path ="customer", method =RequestMethod.POST)
    public String allCostomerForm(@ModelAttribute("cv") CustomerVO cv, Model model) {
    	System.out.println(cv);
    	customerService.saveCustomer(cv);
    	model.addAttribute("cv",customerService.getAllCustomer());
    	return "customer";
    }
    
    
   
}