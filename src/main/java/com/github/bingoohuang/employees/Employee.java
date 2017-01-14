package com.github.bingoohuang.employees;

import lombok.Data;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/14.
 */
@Data
public class Employee {
    private String familyName;
    private String addressLine1;
    private String zipCode;
    private String initials;
    private String city;
}
