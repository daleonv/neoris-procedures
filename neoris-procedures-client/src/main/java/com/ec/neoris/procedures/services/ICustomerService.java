package com.ec.neoris.procedures.services;

import com.ec.neoris.entities.procedures.CustomerEntity;

import java.util.List;

/**
 * Service interface for customer resources
 *
 * @author dalonv
 * @version 1.0
 */
public interface ICustomerService {

    /**
     * Return customer list information
     *
     * @return List<CustomerEntity>
     */
    List<CustomerEntity> findCustomerList();
}
