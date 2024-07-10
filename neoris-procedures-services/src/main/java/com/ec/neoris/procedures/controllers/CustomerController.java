package com.ec.neoris.procedures.controllers;

import com.ec.neoris.entities.procedures.CustomerEntity;
import com.ec.neoris.procedures.config.Response;
import com.ec.neoris.procedures.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("clientes")
@Lazy
public class CustomerController {
    @Lazy
    @Autowired
    private ICustomerService customerService;

    @GetMapping("buscar")
    public ResponseEntity<Response<List<CustomerEntity>>> findCustomerList() {
        return new ResponseEntity<>(Response.<List<CustomerEntity>>builder()
                .data(customerService.findCustomerList())
                .build(), HttpStatus.OK);
    }

}
