package com.ec.test.procedures.services;

import com.ec.test.entities.procedures.CustomerEntity;
import com.ec.test.procedures.AccountStatusRequestVo;
import com.ec.test.procedures.AccountStatusResponseVo;
import com.ec.test.procedures.CustomerVo;

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
