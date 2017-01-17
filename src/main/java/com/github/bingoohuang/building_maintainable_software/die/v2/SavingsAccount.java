package com.github.bingoohuang.building_maintainable_software.die.v2;

import com.github.bingoohuang.building_maintainable_software.die.BusinessException;
import com.github.bingoohuang.building_maintainable_software.die.Money;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/15.
 */
// 储蓄账户
public class SavingsAccount extends Account {
    CheckingAccount registeredCounterAccount;

    public Transfer makeTransfer(String counterAccount, Money amount)
            throws BusinessException {
        Transfer result = super.makeTransfer(counterAccount, amount);
        CheckingAccount account = result.getCounterAccount();
        if (account.equals(registeredCounterAccount)) return result;

        throw new BusinessException("Counter-account not registered!");
    }
}
