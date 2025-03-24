package com.pjdcb2.restaurants_magagement_system.Repository.RepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pjdcb2.restaurants_magagement_system.Repository.TableRepository;
import com.pjdcb2.restaurants_magagement_system.constant.RestaurantCRUDQuery;
import com.pjdcb2.restaurants_magagement_system.model.TableModel;

@Repository
public class TableRepositoryImpl implements TableRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TableModel> getTables() {
        return jdbcTemplate.query(RestaurantCRUDQuery.SELECTALL.query, new RowMapper<TableModel>() {
            @Override
            public TableModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new TableModel(
                    rs.getInt("id"),
                    rs.getInt("table_number"),
                    rs.getBoolean("is_available"), 
                    rowNum
                );
            }
        });
    }
}

