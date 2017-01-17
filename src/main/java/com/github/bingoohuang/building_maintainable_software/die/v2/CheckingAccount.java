package com.github.bingoohuang.building_maintainable_software.die.v2;

import com.github.bingoohuang.building_maintainable_software.die.BusinessException;
import com.github.bingoohuang.building_maintainable_software.die.Money;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/15.
 */
// 银行提供的支票账户
public class CheckingAccount extends Account {
    private int transferLimit = 100;

    public Transfer makeTransfer(String counterAccount, Money amount)
            throws BusinessException {
        // 1. Check withdrawal limit:
        if (amount.greaterThan(transferLimit)) {
            throw new BusinessException("Limit exceeded!");
        }

        return super.makeTransfer(counterAccount, amount);
    }
}