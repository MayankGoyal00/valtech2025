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
import com.valtech.training.CustomerOrderMVC.services.LineItemService;
import com.valtech.training.CustomerOrderMVC.vos.CustomerVO;
import com.valtech.training.CustomerOrderMVC.vos.ItemVO;
import com.valtech.training.CustomerOrderMVC.vos.LineItemVO;

@Controller
public class LineItemController {
 
    @Autowired
    private LineItemService lineItemService;
 
    @RequestMapping("/lineItem")
    public String lineItem() {
    	return "lineItem";
    }
    
    @RequestMapping(path ="/lineItem", method =RequestMethod.POST)
    public String addOrders(@ModelAttribute("pv") ItemVO iv, Model model) {
    	this.lineItemService.savelineItem(iv);
    	model.addAttribute("iv",lineItemService.getAllLineItems());
    	return "item";
    }
}