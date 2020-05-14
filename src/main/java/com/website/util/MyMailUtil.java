package com.website.util;

import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;

/**
 * 邮箱使用配置文件
 */
public class MyMailUtil {
    public static MailAccount account = new MailAccount();
    static {
        account.setHost("smtp.163.com");
        account.setPort(465);
        account.setAuth(true);
        //ssl
        account.setStarttlsEnable(true);
        account.setSslEnable(true);
        account.setSocketFactoryClass("javax.net.ssl.SSLSocketFactory");
        account.setSocketFactoryFallback(true);
        account.setSocketFactoryPort(465);

        account.setFrom("yrtx_liyouran@163.com");
        account.setUser("yrtx_liyouran@163.com");
        account.setPass("DCNFVTXLAWVJWGOH"); //密码
    }
    public static String sendMail(String email, String rand) {
        return MailUtil.send(account, email, "来自星火创意工坊（电子小组）的验证邮件",
                "您的验证码为：" + rand, false);
    }
}
