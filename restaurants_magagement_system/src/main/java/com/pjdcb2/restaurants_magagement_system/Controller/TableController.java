package com.pjdcb2.restaurants_magagement_system.Controller;

import com.pjdcb2.restaurants_magagement_system.Service.ServiceImpl.TableServiceImpl;
import com.pjdcb2.restaurants_magagement_system.model.TableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    private TableServiceImpl tableService;

    @GetMapping("/")
    public String showTables(Model model) {
        List<TableModel> tables = tableService.getTables();
        model.addAttribute("tables", tables);
        return "index";
    }
}

