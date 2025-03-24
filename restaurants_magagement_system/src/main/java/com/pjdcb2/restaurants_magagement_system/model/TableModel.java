package com.pjdcb2.restaurants_magagement_system.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TableModel {
    private int id;
    private int tableNumber;
    private boolean available;
    private int orderCount; 

    public TableModel(int id, int tableNumber, boolean available, int orderCount) {
        super();
        this.id = id;
        this.tableNumber = tableNumber;
        this.available = available;
        this.orderCount = orderCount;
    }

    public boolean isAvailable() {
        return available && orderCount < 10; 
    }
}

