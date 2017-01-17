package com.github.bingoohuang.building_maintainable_software.die.v2;

import com.github.bingoohuang.building_maintainable_software.die.Money;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/17.
 */
public class Account {
    public Transfer makeTransfer(String counterAccount, Money amount) {
        Accounts.validateAccountNumber(counterAccount);

        // 2. Look up counter account and make transfer object:
        CheckingAccount acct = Accounts.findAcctByNumber(counterAccount);
        return new Transfer(this, acct, amount);

    }
}
