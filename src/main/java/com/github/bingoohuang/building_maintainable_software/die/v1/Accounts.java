package com.github.bingoohuang.building_maintainable_software.die.v1;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/15.
 */
public class Accounts {
    public static CheckingAccount findAcctByNumber(String counterAccount) {
        return null;
    }

    public static boolean isValid(String counterAccount) {
        int sum = 0; // <1> 复制代码的起点
        for (int i = 0; i < counterAccount.length(); i++) {
            sum += (9 - i) * Character.getNumericValue(counterAccount.charAt(i));
        }
        return sum % 11 == 0;
    }
}
