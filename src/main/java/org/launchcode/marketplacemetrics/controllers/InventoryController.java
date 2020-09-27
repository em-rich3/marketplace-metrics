package org.launchcode.marketplacemetrics.controllers;

import org.launchcode.marketplacemetrics.data.InventoryData;
import org.launchcode.marketplacemetrics.models.Inventory;
import org.launchcode.marketplacemetrics.models.InventoryCategory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("inventory")
public class InventoryController {

    @RequestMapping("")
    public String index(Model model) {
        return "redirect:all";
    }


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
        model.addAttribute(new Inventory());
        model.addAttribute("categories", InventoryCategory.values());
        return "inventory/add";
    }

    @PostMapping("add")
    public String processAddInventoryForm(@ModelAttribute @Valid Inventory newInventory, Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Add Item");
            return "inventory/add";
        }
        InventoryData.add(newInventory);
        Inventory.nextId++;
        return "redirect:all";
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
