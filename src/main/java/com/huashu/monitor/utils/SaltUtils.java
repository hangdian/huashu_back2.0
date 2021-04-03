package com.huashu.monitor.utils;

import java.util.Random;

/**
 * @Description md5盐工具类
 * @auther supermao
 * @create 2021-03-15 22:47
 */
public class SaltUtils {
    /**
     * 获取一个长度为n的盐
     * @param n 盐的长度
     * @return
     */
    public static String getSalt(int n) {
        // 从这些字符中随机选取n个作为盐
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = chars[new Random().nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }
}
