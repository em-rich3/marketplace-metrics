package org.launchcode.marketplacemetrics.controllers;

import org.launchcode.marketplacemetrics.data.InventoryRepository;
import org.launchcode.marketplacemetrics.models.Inventory;
import org.launchcode.marketplacemetrics.models.InventoryCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("inventory")
public class InventoryController {

    @Autowired
    private InventoryRepository inventoryRepository;

    @RequestMapping("")
    public String index(Model model) {
        return "redirect:all";
    }


    @RequestMapping("bought")
    public String bought(Model model) {
        model.addAttribute("title", "Marketplace Metrics");
        model.addAttribute("inventory", inventoryRepository.findByCategory(InventoryCategory.BOUGHT));
        return "inventory/bought";
    }

    @RequestMapping("sold")
    public String sold(Model model) {
        model.addAttribute("title", "Marketplace Metrics");
        model.addAttribute("inventory", inventoryRepository.findByCategory(InventoryCategory.SOLD));
        return "inventory/sold";
    }

    @RequestMapping("all")
    public String allInventory(Model model) {
        model.addAttribute("title", "Marketplace Metrics");
        model.addAttribute("inventory", inventoryRepository.findAll());
        return "inventory/index";
    }

    @GetMapping("add")
    public String addInventory(Model model) {
        model.addAttribute("title", "Marketplace Metrics");
        model.addAttribute(new Inventory());
        model.addAttribute("categories", InventoryCategory.values());
        return "inventory/add";
    }

    @PostMapping("add")
    public String processAddInventoryForm(@ModelAttribute @Valid Inventory newInventory, Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Marketplace Metrics");
            model.addAttribute("categories", InventoryCategory.values());
            return "inventory/add";
        }
        inventoryRepository.save(newInventory);
        return "redirect:all";
    }

    @GetMapping("delete")
    public String displayDeleteInventoryForm(Model model) {
        model.addAttribute("title", "Marketplace Metrics");
        model.addAttribute("inventory", inventoryRepository.findAll());
        return "inventory/delete";
    }

    @PostMapping("delete")
    public String processDeleteInventoryForm(@RequestParam(required=false) int[] itemIds) {
        if (itemIds != null) {
            for (int id : itemIds) {
                inventoryRepository.deleteById(id);
            }
        }

        return "redirect:/inventory/all";
    }
}
