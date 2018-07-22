package com.book.usersystem.utils;

import java.util.UUID;

/**
 * @Author:Bookman
 * @Date:Created in 19:01 2018/6/5
 */
public class CommonUtils {

    public static String makeId () {
        return UUID.randomUUID().toString();
    }

    public static int makeRandomInt () {
        return ((int)((Math.random()*9+1)*100000));
    }

    public static void main(String[] args) {
        System.out.println(CommonUtils.makeRandomInt());
    }
}
