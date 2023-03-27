package com.andrelcalves.OpenFeignExample.application.controller;

import java.util.List;

import com.andrelcalves.OpenFeignExample.domain.model.TodoModel;
import com.andrelcalves.OpenFeignExample.domain.entity.Cliente;
import com.andrelcalves.OpenFeignExample.infra.client.ClienteRepository;
import com.andrelcalves.OpenFeignExample.infra.client.httpExampleClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClienteController {

        @Autowired
        httpExampleClient todoClient;
        @Autowired
        ClienteRepository clienteRepository;

        @GetMapping(path = "/welcome")
        public String getWelcome(){
             return "Bem vindos";
        }
        @GetMapping(path = "/OpenFeign")
        public List<TodoModel> getTodos()
        {
            return todoClient.getTodos();
        }

        @GetMapping()
        public @ResponseBody Iterable<Cliente> getAllCliente() {
                return clienteRepository.findAll();
        }

        @GetMapping("/{id}")
        public @ResponseBody Cliente getById(@PathVariable Long id){
                return clienteRepository.findById(id)
                        .orElseThrow(()->new ClientNotFoundException("Cliente não encontrado"));
        }

        @GetMapping("/cnpj/{cnpj}")
        public @ResponseBody Cliente getByCnpj(@PathVariable String cnpj){
                return clienteRepository.findByCnpj(cnpj);
        }


        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public Cliente create(@RequestBody Cliente cliente) {
                return clienteRepository.save(cliente);
        }

        @PutMapping
        @ResponseStatus(HttpStatus.OK)
        public Cliente update(@RequestBody Cliente cliente) {
                Cliente clientInDB = clienteRepository.findById(cliente.getId())
                        .orElseThrow(()->new ClientNotFoundException("Cliente não encontrado"));
                clientInDB.setCnpj(cliente.getCnpj());
                clientInDB.setRazaoSocial(cliente.getRazaoSocial());
                return clienteRepository.save(clientInDB);
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id) {
                clienteRepository.findById(id)
                        .orElseThrow(()->new ClientNotFoundException("Cliente não encontrado"));
                clienteRepository.deleteById(id);
        }






}

