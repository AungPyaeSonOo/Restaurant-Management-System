package com.pjdcb2.restaurants_magagement_system.Service;

import java.util.List;

import com.pjdcb2.restaurants_magagement_system.model.OrderModel;

public interface OrderService {

	void placeOrder(OrderModel order);
    List<OrderModel> getOrdersForTable(int tableId);
    void checkoutOrder(int orderId);
    int getOrderCountForTable(int tableId);
    int getTableIdForOrder(int orderId);

}
