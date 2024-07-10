package com.ec.neoris.procedures.services;

import com.ec.neoris.entities.procedures.CustomerEntity;
import com.ec.neoris.procedures.repositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for enterprise resources
 *
 * @author daleonv
 * @version 1.0
 */
@Lazy
@Service
public class CustomerService implements ICustomerService {

    @Lazy
    @Autowired
    private ICustomerRepository customerRepository;


    /**
     * {@inheritDoc}
     */
    @Override
    public List<CustomerEntity> findCustomerList() {
        return customerRepository.findCustomerList();
    }
}
