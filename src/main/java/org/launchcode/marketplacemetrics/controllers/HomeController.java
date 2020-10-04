package org.launchcode.marketplacemetrics.controllers;

import org.launchcode.marketplacemetrics.data.InventoryRepository;
import org.launchcode.marketplacemetrics.models.CashFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private InventoryRepository inventoryRepository;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Marketplace Metrics");
        Map<String, BigDecimal> data = new LinkedHashMap<String, BigDecimal>();
        List<Object[]> cashFlowData = inventoryRepository.getCashFlow();
        Object[] flow = cashFlowData.get(0);
        data.put("BOUGHT", (BigDecimal) flow[1]);
        data.put("SOLD", (BigDecimal) flow[2]);
        data.put("CASH FLOW", (BigDecimal) flow[0]);
        model.addAttribute("data", data);
        return "index";
    }

}
