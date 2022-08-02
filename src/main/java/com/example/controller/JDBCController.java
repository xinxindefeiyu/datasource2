package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jdbc")
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/listUser")
    public List<Map<String, Object>> listUser() {
        String sql = "select * from mybatis.user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @GetMapping("/addUser")
    public String addUser() {
        String sql = "insert into mybatis.user(id,name,pwd) values (4, '晓敏', '1998')";
        jdbcTemplate.update(sql);
        return "add-OK";
    }

    @GetMapping("/updateUser/{id}")
    public String update(@PathVariable("id") int id) {
        String sql = "update mybatis.user set name='小明' where id=" + id;
        jdbcTemplate.update(sql);
        return "update-OK";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        String sql = "delete from mybatis.user where id=" + id;
        jdbcTemplate.update(sql);
        return "delete-ok";
    }




}
