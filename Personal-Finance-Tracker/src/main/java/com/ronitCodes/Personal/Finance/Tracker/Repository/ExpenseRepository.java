package com.ronitCodes.Personal.Finance.Tracker.Repository;

import com.ronitCodes.Personal.Finance.Tracker.Model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expenses, Long> {

    // No need to write code here Lol
}
