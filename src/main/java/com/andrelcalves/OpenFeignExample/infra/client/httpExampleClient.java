package com.andrelcalves.OpenFeignExample.infra.client;

import java.util.List;

import com.andrelcalves.OpenFeignExample.domain.model.TodoModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="Todos",url="https://jsonplaceholder.typicode.com")
public interface httpExampleClient {
        @GetMapping(value="/todos",consumes = MediaType.APPLICATION_JSON_VALUE)
        List<TodoModel>getTodos();
}
