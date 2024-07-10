package com.ec.neoris.procedures.services;

import com.ec.neoris.entities.procedures.TransactionEntity;
import com.ec.neoris.procedures.TransactionVo;

import java.util.List;

/**
 * Service interface for transaction resources
 *
 * @author dalonv
 * @version 1.0
 */
public interface ITransactionService {

    /**
     * Return transaction list information
     *
     * @return List<TransactionEntity>
     */
    List<TransactionEntity> findTransactionList();

    /**
     * Save transaction
     *
     * @param transaction TransactionVo
     */
    void saveTransaction(TransactionVo transaction);

    /**
     * Update transaction information.
     *
     * @param transaction TransactionVo
     */
    void updateTransaction(TransactionVo transaction);

    /**
     * Delete a transaction.
     *
     * @param transactionId Long
     */
    void deleteTransaction(Long transactionId);

}
