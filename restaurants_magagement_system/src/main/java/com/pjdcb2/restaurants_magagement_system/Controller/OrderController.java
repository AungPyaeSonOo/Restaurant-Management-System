package com.pjdcb2.restaurants_magagement_system.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pjdcb2.restaurants_magagement_system.Service.OrderService;
import com.pjdcb2.restaurants_magagement_system.model.OrderModel;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/order/{id}")
    public String showOrderPage(@PathVariable("id") int tableId, Model model) {
        List<OrderModel> orders = orderService.getOrdersForTable(tableId);
        if (orders.size() >= 10) {
            model.addAttribute("maxOrders", true);  
        } else {
            model.addAttribute("maxOrders", false);
        }
        model.addAttribute("tableId", tableId);
        return "order";
    }

    @PostMapping("/order/place")
    public String placeOrder(@RequestParam("tableId") int tableId,
                             @RequestParam("items") String items,
                             @RequestParam("totalPrice") double totalPrice) {

        
        int currentOrders = orderService.getOrdersForTable(tableId).size();
        if (currentOrders >= 10) {
            return "redirect:/checkout/" + tableId; 
        }

        OrderModel order = new OrderModel(0, tableId, items, totalPrice, LocalDateTime.now());
        orderService.placeOrder(order);
        return "redirect:/"; 
    }
}
