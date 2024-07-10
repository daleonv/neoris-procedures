package com.ec.neoris.procedures.services;

import com.ec.neoris.entities.procedures.CustomerEntity;
import com.ec.neoris.entities.procedures.PersonEntity;
import com.ec.neoris.procedures.CustomerVo;
import com.ec.neoris.procedures.repositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Service for customer resources
 *
 * @author daleonv
 * @version 1.0
 */
@Lazy
@Service
@Transactional
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveCustomer(CustomerVo customer) {
        customerRepository.save(CustomerEntity.builder()
                .password(customer.getPassword())
                .status(customer.getStatus())
                .name(customer.getName())
                .gender(PersonEntity.Gender.Hombre)
                .age(customer.getAge())
                .identification(customer.getIdentification())
                .address(customer.getAddress())
                .phone(customer.getPhone())
                .build());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateCustomer(CustomerVo customer) {
        Optional<CustomerEntity> optionalCustomer = customerRepository.findById(customer.getCustomerId());
        if (optionalCustomer.isPresent()) {
            CustomerEntity existingCustomer = getCustomerEntity(customer, optionalCustomer);
            customerRepository.update(existingCustomer);
        } else {
            throw new EntityNotFoundException("Customer with ID " + customer.getCustomerId() + " not found");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteCustomer(Long customerId) {
        Optional<CustomerEntity> optionalCustomer = customerRepository.findById(customerId);
        optionalCustomer.ifPresent(customer -> customerRepository.delete(customer));
    }


    private static CustomerEntity getCustomerEntity(CustomerVo customer, Optional<CustomerEntity> optionalCustomer) {
        CustomerEntity existingCustomer = optionalCustomer.get();
        existingCustomer.setPassword(customer.getPassword());
        existingCustomer.setStatus(customer.getStatus());
        existingCustomer.setName(customer.getName());
        existingCustomer.setGender(PersonEntity.Gender.Hombre);
        existingCustomer.setAge(customer.getAge());
        existingCustomer.setIdentification(customer.getIdentification());
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setPhone(customer.getPhone());
        return existingCustomer;
    }
}
