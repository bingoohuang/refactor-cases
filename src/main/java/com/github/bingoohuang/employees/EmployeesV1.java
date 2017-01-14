package com.github.bingoohuang.employees;


import lombok.val;

public class EmployeesV1 {
    public static void printDepartmentEmployees(String department) {
        val sql = "SELECT FamilyName, Initials, GivenName, " +
                "   AddressLine1, ZIPcode, City " +
                "FROM EMPLOYEES WHERE EmployeeDep = ?";
        val q = new Query(sql);
        val tmpl = new Template("<div name='addressDiv'>" +
                "{FamilyName},<br/>{Initials}<br/>{ZipCod}{City}</div>");
        for (val e : q.execute(department)) {
            System.out.println(tmpl.eval(e));
        }
    }
}
