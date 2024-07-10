package com.ec.neoris.procedures.repositories;

import com.ec.neoris.entities.procedures.CustomerEntity;
import com.ec.neoris.procedures.config.IQueryDslBaseRepository;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for customer resources
 *
 * @author daleonv
 * @version 1.0
 */
public interface ICustomerRepository extends IQueryDslBaseRepository<CustomerEntity> {

    /**
     * Return customer list information
     *
     * @return List<CustomerEntity>
     */
    List<CustomerEntity> findCustomerList();

    /**
     * Return customer information by customerId
     *
     * @return Optional<CustomerEntity>
     */
    Optional<CustomerEntity> findById(Long customerId);

}
