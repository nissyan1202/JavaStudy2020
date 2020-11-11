package com.example.demo3.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class HelloController {

	@Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/hello")
	public String index(Model model) {

        List<Map<String,Object>> list;
        list = jdbcTemplate.queryForList("select * from member");

		model.addAttribute("message", "Hello Minori!!");
		model.addAttribute("list", list);
		return "list";
	}
}