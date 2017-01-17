package com.github.bingoohuang.building_maintainable_software.die.v2;

import com.github.bingoohuang.building_maintainable_software.die.Money;
import lombok.Data;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/15.
 */
@Data
public class Transfer {
    private CheckingAccount counterAccount;

    public Transfer(Account checkingAccount, CheckingAccount acct, Money amount) {

    }
}
