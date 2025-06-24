package com.alexander.financetracker.controller;

import com.alexander.financetracker.model.Transaction;
import com.alexander.financetracker.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @PostMapping("/user/{userId}")
    public Transaction createTransaction(@PathVariable Long userId, @RequestBody Transaction transaction) {
        return transactionService.createTransaction(userId, transaction);
    }

    // Additional endpoints (e.g., getTransactionsByUser, updateTransaction, deleteTransaction) to be added here
}
