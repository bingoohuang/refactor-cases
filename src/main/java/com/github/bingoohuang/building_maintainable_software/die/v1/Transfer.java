package com.github.bingoohuang.building_maintainable_software.die.v1;

import com.github.bingoohuang.building_maintainable_software.die.Money;
import com.github.bingoohuang.building_maintainable_software.jekins.JenkinsUser;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/15.
 */
public class Transfer {
    private JenkinsUser.Strategy counterAccount;

    public Transfer(CheckingAccount checkingAccount, CheckingAccount acct, Money amount) {

    }

    public Transfer(SavingsAccount savingsAccount, CheckingAccount acct, Money amount) {

    }

    public JenkinsUser.Strategy getCounterAccount() {
        return counterAccount;
    }

    public void setCounterAccount(JenkinsUser.Strategy counterAccount) {
        this.counterAccount = counterAccount;
    }
}
