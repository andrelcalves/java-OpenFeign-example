package com.andrelcalves.OpenFeignExample.infra.client;

import org.springframework.data.repository.CrudRepository;
import com.andrelcalves.OpenFeignExample.domain.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{
    public Cliente findByCnpj(String Cnpj);
}


