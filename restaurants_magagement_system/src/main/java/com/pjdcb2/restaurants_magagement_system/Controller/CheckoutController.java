package com.pjdcb2.restaurants_magagement_system.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.pjdcb2.restaurants_magagement_system.Service.OrderService;
import com.pjdcb2.restaurants_magagement_system.Service.TableService;
import com.pjdcb2.restaurants_magagement_system.model.OrderModel;
import com.pjdcb2.restaurants_magagement_system.model.TableModel;

@Controller
public class CheckoutController {

	@Autowired
    private OrderService orderService;
	
	@Autowired
    private TableService tableService;
	

	@GetMapping("/checkout/{tableId}")
	public String checkout(@PathVariable int tableId, Model model) {
	    
	    List<OrderModel> orders = orderService.getOrdersForTable(tableId);
	    model.addAttribute("orders", orders);
	    
	    TableModel table = tableService.getTables().stream()
	        .filter(t -> t.getId() == tableId)
	        .findFirst()
	        .orElse(null);
	    
	    model.addAttribute("tableAvailable", table != null && orders.size() > 0);
	    
	    return "checkout"; 
	}


	@GetMapping("/checkout/order/{orderId}")
	public String completeCheckout(@PathVariable int orderId, Model model) {
	    int tableId = orderService.getTableIdForOrder(orderId); 
	    orderService.checkoutOrder(orderId);
	    
	    return "redirect:/checkout/" + tableId; 
	}


}
