/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved.
 */

/*
 * 修订记录：
 * zheye@yiji.com 2017年03月23日 18:02:22 创建
 */
package top.yunsun.bicycle.common.util;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zheye@yiji.com
 */
public class CaptchaUtil {
    private static final Logger logger = LoggerFactory.getLogger(CaptchaUtil.class);
    public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String upperLetterChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String lowerLetterChar = "abcdefghijklmnopqrstuvwxyz";
    public static final String numberChar = "0123456789";
    public static final String numberLowerLetterChar = "0123456789abcdefghijklmnopqrstuvwxyz";
    public static final String numberUpperLetterChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String getRandomALLChar(int n) {
        return captchaChar(allChar, n);
    }

    public static String getRandomLetterChar(int n) {
        return captchaChar(letterChar, n);
    }

    public static String getRandomUpperLetterChar(int n) {
        return captchaChar(upperLetterChar, n);
    }

    public static String getRandomLowerLetterChar(int n) {
        return captchaChar(lowerLetterChar, n);
    }

    public static String getRandomNumberChar(int n) {
        return captchaChar(numberChar, n);
    }

    public static String getRandomNumberLowerLetterChar(int n) {
        return captchaChar(numberLowerLetterChar, n);
    }

    public static String getRandomNumberUpperLetterChar(int n) {
        return captchaChar(numberUpperLetterChar, n);
    }

    private static String captchaChar(final String chars, int n) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

}
