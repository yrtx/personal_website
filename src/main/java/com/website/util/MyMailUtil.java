package com.website.util;

import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;

public class MyMailUtil {
    public static MailAccount account = new MailAccount();
    static {
        account.setHost("smtp.163.com");
        account.setPort(25);
        account.setAuth(true);
        account.setFrom("yrtx_liyouran@163.com");
        account.setUser("yrtx_liyouran@163.com");
        account.setPass("DCNFVTXLAWVJWGOH"); //密码
    }
    public static void sendMail(String email, String rand) {
        MailUtil.send(account, email, "来自星火创意工坊（电子小组）的验证邮件",
                "您的验证码为："+rand, false);

    }
}
