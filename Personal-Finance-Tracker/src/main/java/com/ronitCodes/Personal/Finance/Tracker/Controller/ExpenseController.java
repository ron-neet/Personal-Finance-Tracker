package com.ronitCodes.Personal.Finance.Tracker.Controller;

import com.ronitCodes.Personal.Finance.Tracker.Model.Expense;
import com.ronitCodes.Personal.Finance.Tracker.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // This method maps the root url
    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Expense> expense = expenseService.getAllExpenses();
        //collection frame work
        BigDecimal totalAmount = expense.stream()
                .map(Expense::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        model.addAttribute("expenses", expense);
        model.addAttribute("totalExpense", totalAmount);
        return "index";
    }

    @GetMapping("/addExpense")
    public String addExpensePage(Model model){
        Expense expense = new Expense();
        model.addAttribute("expense", expense);
        return "add-expense";
    }

    @PostMapping("/saveExpense")
    public String saveExpense(@ModelAttribute("expense") Expense expense, Model model){
        expenseService.saveExpense(expense);
        return "redirect:/";
    }

    @GetMapping("/editExpense/{id}")
    public String showUpdateExpensePage(@PathVariable(value = "id")long id, Model model){
        Expense expense = expenseService.getExpenseById(id);
        model.addAttribute("expense", expense);
        return "update-expense";
    }

    @PostMapping("/updateExpense/{id}")
    public String updateExpense(@PathVariable(value ="id") Long id,
                                @ModelAttribute("expense") Expense expense,
                                Model model){
        Expense existingExpense = expenseService.getExpenseById(id);

        existingExpense.setDescription(expense.getDescription());
        existingExpense.setAmount(expense.getAmount());

        expenseService.saveExpense(existingExpense);
        return "redirect:/";
    }

    @GetMapping("/deleteExpense/{id}")
    public String deleteExpense(@PathVariable(value = "id")Long id){
        expenseService.deleteExpense(id);
        return "redirect:/";
    }
}
