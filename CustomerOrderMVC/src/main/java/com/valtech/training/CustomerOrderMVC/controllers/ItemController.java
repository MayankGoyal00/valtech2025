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
import com.valtech.training.CustomerOrderMVC.services.ItemService;
import com.valtech.training.CustomerOrderMVC.vos.CustomerVO;
import com.valtech.training.CustomerOrderMVC.vos.ItemVO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ItemController {
 
    @Autowired
    private ItemService itemService;
   
    @RequestMapping("/item")
    public String showItem() {
    	return "item";
    }
    
    @RequestMapping(path ="/item", method =RequestMethod.POST)
    public String itemForm(@ModelAttribute("iv") ItemVO iv, Model model) {
    	this.itemService.saveItem(iv);
    	model.addAttribute("iv",itemService.getAllItems());
    	return "item";
    }
}