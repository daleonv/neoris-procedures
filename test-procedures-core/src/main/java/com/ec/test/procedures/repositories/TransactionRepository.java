package com.ec.test.procedures.repositories;

import com.ec.test.procedures.config.JPAQueryDslBaseRepository;
import com.ec.test.entities.procedures.TransactionEntity;
import com.querydsl.core.types.Projections;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.ec.test.entities.procedures.QTransactionEntity.transactionEntity;

/**
 * Repository for transaction resources
 *
 * @author daleonv
 * @version 1.0
 */
@Lazy
@Repository
public class TransactionRepository extends JPAQueryDslBaseRepository<TransactionEntity> implements ITransactionRepository {
    public TransactionRepository() {
        super(TransactionEntity.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<TransactionEntity> findTransactionList() {
        return from(transactionEntity).select(Projections.bean(TransactionEntity.class,
                                transactionEntity.date,
                                transactionEntity.transactionType,
                                transactionEntity.amount,
                                transactionEntity.balance,
                                transactionEntity.account.accountId,
                                transactionEntity.status
                        )
                )
                .stream().toList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<TransactionEntity> findById(Long transactionId) {
        return from(transactionEntity)
                .where(transactionEntity.transactionId.eq(transactionId))
                .select(Projections.bean(TransactionEntity.class,
                        transactionEntity.date,
                        transactionEntity.transactionType,
                        transactionEntity.amount,
                        transactionEntity.balance,
                        transactionEntity.account.accountId,
                        transactionEntity.status
                ))
                .stream().findFirst();
    }

}
