package com.ec.neoris.procedures.repositories;

import com.ec.neoris.entities.procedures.CustomerEntity;
import com.querydsl.core.types.Projections;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.ec.neoris.entities.procedures.QCustomerEntity.customerEntity;

/**
 * Repository for customer resources
 *
 * @author daleonv
 * @version 1.0
 */
@Lazy
@Repository
public class CustomerRepository extends JPAQueryDslBaseRepository<CustomerEntity> implements ICustomerRepository {
    public CustomerRepository() {
        super(CustomerEntity.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CustomerEntity> findCustomerList() {
        return from(customerEntity).select(Projections.bean(CustomerEntity.class,
                                customerEntity.name,
                                customerEntity.gender,
                                customerEntity.identification,
                                customerEntity.address,
                                customerEntity.phone,
                                customerEntity.customerId,
                                customerEntity.password,
                                customerEntity.status,
                                customerEntity.age
                        )
                )
                .stream().toList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<CustomerEntity> findById(Long customerId) {
        return from(customerEntity)
                .where(customerEntity.customerId.eq(customerId))
                .select(Projections.bean(CustomerEntity.class,
                        customerEntity.name,
                        customerEntity.gender,
                        customerEntity.identification,
                        customerEntity.address,
                        customerEntity.phone,
                        customerEntity.customerId,
                        customerEntity.password,
                        customerEntity.status,
                        customerEntity.age
                ))
                .stream().findFirst();
    }

    /**
     * {@inheritDoc}

    @Override
    public void deleteById(Long customerId){

    } */

}
