package com.melek.hopperreceipt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReceiptController {
	
	
	// class definition and imports here...
    @RequestMapping("/")
    public String index(Model model) {
        
        String name = "Grace Hopper";
        model.addAttribute("name", name);
        String itemName = "Copper wire";
        model.addAttribute("itemName", itemName);
        double price = 5.25;
        model.addAttribute("price", price);
        String description = "Metal strips, also an illustration of nanoseconds.";
        model.addAttribute("description", description);
        String vendor = "Little Things Corner Store";
        model.addAttribute("vendor", vendor);
    
    	// Your code here! Add values to the view model to be rendered
    
        return "index.jsp";
    }
    //...
    

}
