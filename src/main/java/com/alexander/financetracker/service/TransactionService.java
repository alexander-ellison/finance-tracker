package com.alexander.financetracker.service;

import com.alexander.financetracker.model.Transaction;
import com.alexander.financetracker.model.User;
import com.alexander.financetracker.repository.TransactionRepository;
import com.alexander.financetracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction createTransaction(Long userId, Transaction transaction) {
        Optional<User> user = userRepository.findById(userId);
        user.ifPresent(transaction::setUser);
        return transactionRepository.save(transaction);
    }

    // Additional methods (e.g., getTransactionsByUser, updateTransaction, deleteTransaction) to be added here
}
