package com.website.test;

import com.website.util.MyMailUtil;

public class TestEmail {
    public static void main(String[] args) {
        String s = MyMailUtil.sendMail("2627447475@qq.com", "2518");
        System.out.println(s);
    }
}
