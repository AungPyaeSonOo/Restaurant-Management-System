package com.pjdcb2.restaurants_magagement_system.Service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjdcb2.restaurants_magagement_system.Repository.OrderRepository;
import com.pjdcb2.restaurants_magagement_system.Service.OrderService;
import com.pjdcb2.restaurants_magagement_system.model.OrderModel;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void placeOrder(OrderModel order) {
        orderRepository.placeOrder(order);
    }

    @Override
    public List<OrderModel> getOrdersForTable(int tableId) {
        return orderRepository.getOrdersForTable(tableId);
    }

    @Override
    public void checkoutOrder(int orderId) {
        orderRepository.checkoutOrder(orderId);
    }

	@Override
	public int getOrderCountForTable(int tableId) {
		return orderRepository.getOrderCountForTable(tableId);
	}
	
	@Override
	public int getTableIdForOrder(int orderId) {
	    return orderRepository.getTableIdForOrder(orderId);
	}


}
