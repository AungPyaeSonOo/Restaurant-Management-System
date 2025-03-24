package com.pjdcb2.restaurants_magagement_system.Repository.RepositoryImpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.pjdcb2.restaurants_magagement_system.Repository.OrderRepository;
import com.pjdcb2.restaurants_magagement_system.constant.RestaurantCRUDQuery;
import com.pjdcb2.restaurants_magagement_system.model.OrderModel;


@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void placeOrder(OrderModel order) {
        jdbcTemplate.update(RestaurantCRUDQuery.INSERT.query, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1, order.getTableId());
                ps.setString(2, order.getItems());
                ps.setDouble(3, order.getTotalPrice());
                ps.setObject(4, order.getOrderTime());
            }
        });
    }

    @SuppressWarnings("deprecation")
	@Override
    public List<OrderModel> getOrdersForTable(int tableId) {
        return jdbcTemplate.query(RestaurantCRUDQuery.SELECT_ORDER.query,
            new Object[]{tableId},
            (rs, rowNum) -> new OrderModel(
                rs.getInt("id"),
                rs.getInt("table_id"),
                rs.getString("items"),
                rs.getDouble("total_price"),
                rs.getTimestamp("order_time").toLocalDateTime()
            )
        );
    }


    @Override
    public void checkoutOrder(int orderId) {
        jdbcTemplate.update(RestaurantCRUDQuery.DELETE.query, orderId);
    }
    
	
    @SuppressWarnings("deprecation")
	@Override
    public int getOrderCountForTable(int tableId) {
        String query = "SELECT COUNT(*) FROM orders WHERE table_id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{tableId}, Integer.class);
    }
    
    @SuppressWarnings("deprecation")
	@Override
    public int getTableIdForOrder(int orderId) {
        return jdbcTemplate.queryForObject(RestaurantCRUDQuery.SELECT_CHECKOUT.query, new Object[]{orderId}, Integer.class);
    }


}
