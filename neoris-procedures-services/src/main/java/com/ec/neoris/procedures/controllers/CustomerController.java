package com.ec.neoris.procedures.controllers;

import com.ec.neoris.entities.procedures.CustomerEntity;
import com.ec.neoris.procedures.CustomerVo;
import com.ec.neoris.procedures.config.Response;
import com.ec.neoris.procedures.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("clientes")
@Lazy
public class CustomerController {
    @Lazy
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public ResponseEntity<Response<List<CustomerEntity>>> findCustomerList() {
        return new ResponseEntity<>(Response.<List<CustomerEntity>>builder()
                .data(customerService.findCustomerList())
                .code(HttpStatus.OK.value())
                .build(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Response<Void>> saveCustomer(
            @RequestBody CustomerVo customer) throws IOException {
        customerService.saveCustomer(customer);
        return new ResponseEntity<>(Response.<Void>builder()
                .code(HttpStatus.CREATED.value())
                .message("Creado con éxito")
                .build(), HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Response<Void>> updateCustomer(@PathVariable Long customerId, @RequestBody CustomerVo customer) {
        customer.setCustomerId(customerId);
        customerService.updateCustomer(customer);
        return new ResponseEntity<>(Response.<Void>builder()
                .code(HttpStatus.OK.value())
                .message("Actualizado con éxito")
                .build(), HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.ok().build();
    }

}
