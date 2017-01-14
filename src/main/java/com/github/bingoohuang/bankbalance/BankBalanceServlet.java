package com.github.bingoohuang.bankbalance;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/*
银行账号校验码11-Check
11-check是用来校验荷兰9位银行账号的校验码。该校验码是银行账号从右到左9位数字的加权总和。
最左侧的数字权重为9，最右侧的数字权重为1。当且仅当银行账号的校验码可以被11整除时，该银行
账号才为有效账号。这个校验码可以用来检查银行账号中的数字是否存在错误。

举例来说，假设银行账号是12.34.56.789。我们将号码中的数字从左到右加权相加：
1*9+2*8+3*7+4*6+5*5+6*4+7*3+8*2+9*1=165。由于165=15*11，所以这个号码是有效的。
 */
public class BankBalanceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Properties conf;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("application/json");
        try {
            Connection conn = DriverManager.
                    getConnection(this.conf.getProperty("handler.jdbcurl"));
            ResultSet results =
                    conn.createStatement()
                            .executeQuery(
                                    "SELECT account, balance FROM ACCTS WHERE id="
                                            + req.getParameter(conf.
                                            getProperty("request.parametername")));
            float totalBalance = 0;
            resp.getWriter().print("{\"balances\":[");
            while (results.next()) {
                // Assuming result is 9-digit bank account number,
                // validate with 11-test:
                int sum = 0;
                for (int i = 0; i < results.getString("account")
                        .length(); i++) {
                    sum = sum + (9 - i)
                            * Character.getNumericValue(results.getString(
                            "account").charAt(i));
                }
                if (sum % 11 == 0) {
                    totalBalance += results.getFloat("balance");
                    resp.getWriter().print(
                            "{\"" + results.getString("account") + "\":"
                                    + results.getFloat("balance") + "}");
                }
                if (results.isLast()) {
                    resp.getWriter().println("],");
                } else {
                    resp.getWriter().print(",");
                }
            }
            resp.getWriter().println("\"total\":" + totalBalance + "}");
        } catch (SQLException e) {
            System.out.println("SQL exception: " + e.getMessage());
        }
    }
}