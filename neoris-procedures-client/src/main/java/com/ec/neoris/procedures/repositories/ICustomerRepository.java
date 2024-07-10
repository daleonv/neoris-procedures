package com.ec.neoris.procedures.repositories;

import com.ec.neoris.entities.procedures.CustomerEntity;

import java.util.List;

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
}
