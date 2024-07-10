package com.ec.neoris.procedures.controllers;

import com.ec.neoris.entities.procedures.TransactionEntity;
import com.ec.neoris.procedures.TransactionVo;
import com.ec.neoris.procedures.config.Response;
import com.ec.neoris.procedures.services.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("movimientos")
@Lazy
public class TransactionController {
    @Lazy
    @Autowired
    private ITransactionService transactionService;

    @GetMapping("")
    public ResponseEntity<Response<List<TransactionEntity>>> findTransactionList() {
        return new ResponseEntity<>(Response.<List<TransactionEntity>>builder()
                .data(transactionService.findTransactionList())
                .code(HttpStatus.OK.value())
                .build(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Response<Void>> saveTransaction(
            @RequestBody TransactionVo transaction) throws IOException {
        transactionService.saveTransaction(transaction);
        return new ResponseEntity<>(Response.<Void>builder()
                .code(HttpStatus.CREATED.value())
                .message("Creado con éxito")
                .build(), HttpStatus.CREATED);
    }

    @PutMapping("/{transactionId}")
    public ResponseEntity<Response<Void>> updateTransaction(@PathVariable Long transactionId,
                                                            @RequestBody TransactionVo transaction) {
        transaction.setTransactionId(transactionId);
        transactionService.updateTransaction(transaction);
        return new ResponseEntity<>(Response.<Void>builder()
                .code(HttpStatus.OK.value())
                .message("Actualizado con éxito")
                .build(), HttpStatus.OK);
    }

    @DeleteMapping("/{transactionId}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long transactionId) {
        transactionService.deleteTransaction(transactionId);
        return ResponseEntity.ok().build();
    }

}
