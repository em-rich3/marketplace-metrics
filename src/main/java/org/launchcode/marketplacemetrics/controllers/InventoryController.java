package org.launchcode.marketplacemetrics.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InventoryController {

    @RequestMapping("bought")
    public String bought(Model model) {
        model.addAttribute("title", "Items Bought");
        return "inventory/bought";
    }

    @RequestMapping("sold")
    public String sold(Model model) {
        model.addAttribute("title", "Items Sold");
        return "inventory/sold";
    }

    @RequestMapping("inventory")
    public String allInventory(Model model) {
        model.addAttribute("title", "All Inventory");
        return "inventory/index";
    }

    @RequestMapping("add")
    public String addInventory(Model model) {
        model.addAttribute("title", "Add Item");
        return "inventory/add";
    }
}
