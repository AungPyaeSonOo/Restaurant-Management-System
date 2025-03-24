package com.pjdcb2.restaurants_magagement_system.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderModel {
    private int id;
    private int tableId;
    private String items;
    private double totalPrice;
    private LocalDateTime orderTime;

    public OrderModel(int id, int tableId, String items, double totalPrice, LocalDateTime orderTime) {
        super();
        this.id = id;
        this.tableId = tableId;
        this.items = items;
        this.totalPrice = totalPrice;
        this.orderTime = orderTime;
    }
}
