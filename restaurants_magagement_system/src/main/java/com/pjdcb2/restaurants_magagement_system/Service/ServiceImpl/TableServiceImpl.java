package com.pjdcb2.restaurants_magagement_system.Service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjdcb2.restaurants_magagement_system.Repository.OrderRepository;
import com.pjdcb2.restaurants_magagement_system.Repository.TableRepository;
import com.pjdcb2.restaurants_magagement_system.Service.TableService;
import com.pjdcb2.restaurants_magagement_system.model.TableModel;

@Service
public class TableServiceImpl implements TableService {
	
	@Autowired
	private TableRepository tableRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<TableModel> getTables() {
	    List<TableModel> tables = tableRepository.getTables();

	    for (TableModel table : tables) {
	        int orderCount = orderRepository.getOrderCountForTable(table.getId());
	        table.setOrderCount(orderCount);
	    }

	    return tables;
	}

	

	
}
