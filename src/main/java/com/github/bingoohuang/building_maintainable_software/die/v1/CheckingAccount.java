package com.github.bingoohuang.building_maintainable_software.die.v1;

import com.github.bingoohuang.building_maintainable_software.die.BusinessException;
import com.github.bingoohuang.building_maintainable_software.die.Money;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/15.
 */
// 银行提供的支票账户
public class CheckingAccount {
    private int transferLimit = 100;

    public Transfer makeTransfer(String counterAccount, Money amount)
            throws BusinessException {
        // 1. Check withdrawal limit:
        if (amount.greaterThan(this.transferLimit)) {
            throw new BusinessException("Limit exceeded!");
        }
        if (Accounts.isValid(counterAccount)) { // <1>
            // 2. Look up counter account and make transfer object:
            CheckingAccount acct = Accounts.findAcctByNumber(counterAccount);
            Transfer result = new Transfer(this, acct, amount); // <2>
            return result;
        } else {
            throw new BusinessException("Invalid account number!");
        }
    }
}