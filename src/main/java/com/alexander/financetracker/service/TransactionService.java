package com.alexander.financetracker.service;

import com.alexander.financetracker.model.Transaction;
import com.alexander.financetracker.model.User;
import com.alexander.financetracker.repository.TransactionRepository;
import com.alexander.financetracker.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;

    public Transaction getTransactionById (Long id) {
        return transactionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Transaction not found"));
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public List<Transaction> getTransactionsByUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
        return transactionRepository.findByUser(user);
    }

    public Transaction createTransaction(Long userId, Transaction transaction) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
        transaction.setUser(user);
        return transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(Long id, Transaction txDetails) {
        Transaction tx = getTransactionById(id);
        if (txDetails.getAmount() != null) tx.setAmount(txDetails.getAmount());
        if (txDetails.getType() != null) tx.setType(txDetails.getType());
        if (txDetails.getCategory() != null) tx.setCategory(txDetails.getCategory());
        if (txDetails.getDate() != null)  tx.setDate(txDetails.getDate());
        return transactionRepository.save(tx);
    }

    public void deleteTransaction(Long id) {
        Transaction tx = getTransactionById(id);
        transactionRepository.delete(tx);
    }
}
