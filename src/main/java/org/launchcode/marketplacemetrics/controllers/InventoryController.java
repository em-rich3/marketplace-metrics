package org.launchcode.marketplacemetrics.controllers;

import org.launchcode.marketplacemetrics.data.InventoryData;
import org.launchcode.marketplacemetrics.models.Inventory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("inventory")
public class InventoryController {

    @RequestMapping("bought")
    public String bought(Model model) {
        model.addAttribute("title", "Items Bought");
        model.addAttribute("inventory", InventoryData.getAll());
        return "inventory/bought";
    }

    @RequestMapping("sold")
    public String sold(Model model) {
        model.addAttribute("title", "Items Sold");
        model.addAttribute("inventory", InventoryData.getAll());
        return "inventory/sold";
    }

    @RequestMapping("all")
    public String allInventory(Model model) {
        model.addAttribute("title", "All Inventory");
        model.addAttribute("inventory", InventoryData.getAll());
        return "inventory/index";
    }

    @GetMapping("add")
    public String addInventory(Model model) {
        model.addAttribute("title", "Add Item");
        return "inventory/add";
    }

    @PostMapping("add")
    public String processAddInventoryForm(@RequestParam String name, @RequestParam Integer price, @RequestParam String category) {
        InventoryData.add(new Inventory(name, price, category));
        return "redirect:/inventory/all";
    }

    @GetMapping("delete")
    public String displayDeleteInventoryForm(Model model) {
        model.addAttribute("title", "Delete Inventory");
        model.addAttribute("inventory", InventoryData.getAll());
        return "inventory/delete";
    }

    @PostMapping("delete")
    public String processDeleteInventoryForm(@RequestParam(required=false) int[] itemIds) {
        if (itemIds != null) {
            for (int id : itemIds) {
                InventoryData.remove(id);
            }
        }

        return "redirect:/inventory/all";
    }
}
