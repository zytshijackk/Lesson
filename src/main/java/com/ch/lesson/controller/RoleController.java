package com.ch.lesson.controller;

import com.ch.lesson.service.RoleIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2019-04-10
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleIService roleIService;

    @GetMapping(value ="/{id}")
    public Object get(@PathVariable("id") Long id){
        System.out.println(id);
        return roleIService.getById(id);
    }
}
