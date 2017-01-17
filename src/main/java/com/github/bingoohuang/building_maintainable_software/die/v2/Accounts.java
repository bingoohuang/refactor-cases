package com.github.bingoohuang.building_maintainable_software.die.v2;

import com.github.bingoohuang.building_maintainable_software.die.BusinessException;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/15.
 */
public class Accounts {
    public static CheckingAccount findAcctByNumber(String counterAccount) {
        return null;
    }

    public static void validateAccountNumber(String counterAccount) {
        int sum = 0; // <1> 复制代码的起点
        for (int i = 0; i < counterAccount.length(); i++) {
            sum += (9 - i) * Character.getNumericValue(counterAccount.charAt(i));
        }
        if (sum % 11 == 0) return;

        throw new BusinessException("Invalid account number:" + counterAccount);
    }
}
