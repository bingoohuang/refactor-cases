package com.github.bingoohuang.employees;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/14.
 */
public class EmployeesV0 {
    public static void printDepartmentEmployees(String department) {
        Query q = new Query();
        for (Employee e : q.addColumn("FamilyName")
                .addColumn("Initials")
                .addColumn("GivenName")
                .addColumn("AddressLine1")
                .addColumn("ZIPcode")
                .addColumn("City")
                .addTable("EMPLOYEES")
                .addWhere("EmployeeDep='" + department + "'")
                .execute()) {
            System.out.println("<div name='addressDiv'" + e.getFamilyName()
                    + ", " + e.getInitials() + "<br />" + e.getAddressLine1()
                    + "<br />" + e.getZipCode() + e.getCity() + "</div>");
        }
    }
    // 这个方法超过14行（实际16行），看上去好像已经无法再拆分了
    // 来自 https://github.com/oreillymedia/building_maintainable_software/blob/master/src/java/eu/sig/training/ch02/Employees.java
    //《代码不朽-编写可维护代码的10大原则》-第2章，反对意见：这个代码单元无法再拆分了

    // 简单的重构，就是将q.addColumn("FamilyName")开始到.execute()结束的9行，提取到一个新方法中
}
