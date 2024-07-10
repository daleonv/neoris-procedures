package com.ec.neoris.procedures.services;

import com.ec.neoris.entities.procedures.CustomerEntity;
import com.ec.neoris.procedures.AccountStatusRequestVo;
import com.ec.neoris.procedures.AccountStatusResponseVo;
import com.ec.neoris.procedures.CustomerVo;

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

    /**
     * Save customer
     *
     * @param customer CustomerVo
     */
    void saveCustomer(CustomerVo customer);

    /**
     * Update customer information.
     *
     * @param customer CustomerVo
     */
    void updateCustomer(CustomerVo customer);

    /**
     * Delete a customer.
     *
     * @param customerId Long
     */
    void deleteCustomer(Long customerId);

    /**
     * Return account status
     *
     * @param filters AccountStatusRequestVo
     * @return List<AccountStatusResponseVo>
     */
    List<AccountStatusResponseVo> findAccountStatus(AccountStatusRequestVo filters);
}
