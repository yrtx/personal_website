package com.website.test;

import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
public class TestEmail {
    public static void main(String[] args) {
        MailAccount account = new MailAccount();
        account.setHost("smtp.163.com");
        account.setPort(25);
        account.setAuth(true);
        account.setFrom("yrtx_liyouran@163.com");
        account.setUser("yrtx_liyouran@163.com");
        account.setPass("DCNFVTXLAWVJWGOH"); //密码
        MailUtil.send(account, "2838458346@qq.com", "测试", "邮件来自Hutool测试", false);
    }
}
