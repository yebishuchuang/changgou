//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.fh.changgou.entity;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public class ChineseUtils {
    private static Random random = null;

    public ChineseUtils() {
    }

    private static Random getRandomInstance() {
        if (random == null) {
            random = new Random(System.currentTimeMillis());
        }

        return random;
    }

    public static String getChinese() {
        String str = null;
        Random random = getRandomInstance();
        int highPos = 176 + Math.abs(random.nextInt(39));
        int lowPos = 161 + Math.abs(random.nextInt(93));
        byte[] b = new byte[]{(new Integer(highPos)).byteValue(), (new Integer(lowPos)).byteValue()};

        try {
            str = new String(b, "GB2312");
        } catch (UnsupportedEncodingException var6) {
            var6.printStackTrace();
        }

        return str;
    }

    public static String getFixedLengthChinese(int length) {
        String str = "";

        for(int i = length; i > 0; --i) {
            str = str + getChinese();
        }

        return str;
    }

    public static String getRandomLengthChiness(int start, int end) {
        String str = "";
        int length = (new Random()).nextInt(end + 1);
        if (length < start) {
            str = getRandomLengthChiness(start, end);
        } else {
            for(int i = 0; i < length; ++i) {
                str = str + getChinese();
            }
        }

        return str;
    }

    public static void main(String[] args) {
        System.out.println(getChinese());
        System.out.println(getFixedLengthChinese(20));
        System.out.println(getRandomLengthChiness(2, 5));
    }
}
