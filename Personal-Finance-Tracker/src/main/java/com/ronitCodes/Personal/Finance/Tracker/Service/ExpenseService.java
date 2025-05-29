package com.ronitCodes.Personal.Finance.Tracker.Service;

import com.ronitCodes.Personal.Finance.Tracker.Model.Expense;
import com.ronitCodes.Personal.Finance.Tracker.Repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }

    public void saveExpense(Expense expense){
        expenseRepository.save(expense);
    }

    public Expense getExpenseById(long id){
        return expenseRepository.findById(id).orElse(null);
    }

    public void deleteExpense(long id){
        expenseRepository.deleteById(id);
    }
}
