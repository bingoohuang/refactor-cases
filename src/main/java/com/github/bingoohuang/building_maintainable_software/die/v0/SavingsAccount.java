package com.github.bingoohuang.building_maintainable_software.die.v0;

import com.github.bingoohuang.building_maintainable_software.die.BusinessException;
import com.github.bingoohuang.building_maintainable_software.die.Money;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/15.
 */
// 储蓄账户
public class SavingsAccount {
    CheckingAccount registeredCounterAccount;

    public Transfer makeTransfer(String counterAccount, Money amount)
            throws BusinessException {
        // 1. Assuming result is 9-digit bank account number, validate 11-test:
        int sum = 0; // <1> 复制代码的起点
        for (int i = 0; i < counterAccount.length(); i++) {
            sum = sum + (9 - i) * Character.getNumericValue(
                    counterAccount.charAt(i));
        }
        if (sum % 11 == 0) {
            // 2. Look up counter account and make transfer object:
            CheckingAccount acct = Accounts.findAcctByNumber(counterAccount);
            Transfer result = new Transfer(this, acct, amount); // <2> // 复制代码的终点
            // 3. Check whether withdrawal is to registered counter account:
            if (result.getCounterAccount().equals(this.registeredCounterAccount))
            {
                return result;
            } else {
                throw new BusinessException("Counter-account not registered!");
            }
        } else {
            throw new BusinessException("Invalid account number!!");
        }
    }
}
