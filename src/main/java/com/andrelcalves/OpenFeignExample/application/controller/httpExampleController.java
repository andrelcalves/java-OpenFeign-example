package com.andrelcalves.OpenFeignExample.application.controller;

import java.util.List;

import com.andrelcalves.OpenFeignExample.domain.model.TodoModel;
import com.andrelcalves.OpenFeignExample.infra.client.httpExampleClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class httpExampleController {

        @Autowired
        httpExampleClient todoClient;

        @GetMapping()
        public List<TodoModel> getTodos()
        {
            return todoClient.getTodos();
        }
}

