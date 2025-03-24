package com.pjdcb2.restaurants_magagement_system.constant;

public enum RestaurantCRUDQuery {
    SELECTALL("SELECT id, table_number, is_available FROM tables;"),
    INSERT("INSERT INTO orders (table_id, items, total_price, order_time) VALUES (?, ?, ?, ?);"),
    SELECT_ORDER("SELECT id, table_id, items, total_price, order_time FROM orders WHERE table_id = ?"),
    DELETE("DELETE FROM orders WHERE id = ?;"),
    UPDATE_TABLE_AVAILABILITY("UPDATE tables SET is_available = ? WHERE id = ?;"),
	SELECT_CHECKOUT("SELECT table_id FROM orders WHERE id = ?;");


    public final String query;

    RestaurantCRUDQuery(String query) {
        this.query = query;
    }
}