package com.website.test;

import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import com.website.util.MyMailUtil;

public class TestEmail {
    public static void main(String[] args) {
        MyMailUtil.sendMail("2627447475@qq.com", "2518");
    }
}
