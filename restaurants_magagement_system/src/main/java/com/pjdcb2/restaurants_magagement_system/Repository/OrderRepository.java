package com.pjdcb2.restaurants_magagement_system.Repository;

import java.util.List;

import com.pjdcb2.restaurants_magagement_system.model.OrderModel;

public interface OrderRepository {

	void placeOrder(OrderModel order);
    List<OrderModel> getOrdersForTable(int tableId);
    void checkoutOrder(int orderId);
    public int getOrderCountForTable(int tableId);
    int getTableIdForOrder(int orderId);
}
