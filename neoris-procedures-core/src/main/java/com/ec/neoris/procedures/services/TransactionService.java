package com.ec.neoris.procedures.services;

import com.ec.neoris.entities.procedures.AccountEntity;
import com.ec.neoris.entities.procedures.TransactionEntity;
import com.ec.neoris.procedures.TransactionVo;
import com.ec.neoris.procedures.repositories.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Service for transaction resources
 *
 * @author daleonv
 * @version 1.0
 */
@Lazy
@Service
@Transactional
public class TransactionService implements ITransactionService {

    @Lazy
    @Autowired
    private ITransactionRepository transactionRepository;


    /**
     * {@inheritDoc}
     */
    @Override
    public List<TransactionEntity> findTransactionList() {
        return transactionRepository.findTransactionList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveTransaction(TransactionVo transaction) {
        transactionRepository.save(TransactionEntity.builder()
                .date(transaction.getDate())
                .transactionType(TransactionEntity.TransactionType.Deposito)
                .amount(transaction.getAmount())
                .balance(transaction.getBalance())
                .account(AccountEntity.builder().accountId(transaction.getAccountId()).build())
                .status(transaction.getStatus())
                .build());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateTransaction(TransactionVo transaction) {
        Optional<TransactionEntity> optionalTransaction = transactionRepository.findById(transaction.getTransactionId());
        if (optionalTransaction.isPresent()) {
            TransactionEntity existingTransaction = getTransactionEntity(transaction, optionalTransaction);
            transactionRepository.update(existingTransaction);
        } else {
            throw new EntityNotFoundException("Transaction with ID " + transaction.getTransactionId() + " not found");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteTransaction(Long transactionId) {
        Optional<TransactionEntity> optionalTransaction = transactionRepository.findById(transactionId);
        optionalTransaction.ifPresent(transaction -> transactionRepository.delete(transaction));
    }


    private static TransactionEntity getTransactionEntity(TransactionVo transaction, Optional<TransactionEntity> optionalTransaction) {
        TransactionEntity existingTransaction = optionalTransaction.get();
        existingTransaction.setDate(transaction.getDate());
        existingTransaction.setTransactionType(TransactionEntity.TransactionType.Deposito);
        existingTransaction.setAmount(transaction.getAmount());
        existingTransaction.setBalance(transaction.getBalance());
        existingTransaction.setAccount(AccountEntity.builder().accountId(transaction.getAccountId()).build());
        existingTransaction.setStatus(transaction.getStatus());
        return existingTransaction;
    }
}
