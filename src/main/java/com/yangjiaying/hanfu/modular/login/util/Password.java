package com.yangjiaying.hanfu.modular.login.util;

import org.junit.Test;

/**
 * 工具类
 * @PackageName:com.yangjiaying.hanfu.modular.login.util
 * @ClassName:jiamiPassword
 * @author:yangjiaying
 * @date 2019/11/11 11:13
 */
public class Password {
    /**
     * 使用凯撒加密方式加密数据
     *
     * @param orignal :原文
     * @param key     :密钥
     * @return :加密后的数据
     */
    public static String jiami(String orignal, int key) {
        // 将字符串转为字符数组
        char[] chars = orignal.toCharArray();
        StringBuilder sb = new StringBuilder();
        // 遍历数组
        for (char aChar : chars) {
            // 获取字符的ASCII编码
            int asciiCode = aChar;
            // 偏移数据
            asciiCode += key;
            // 将偏移后的数据转为字符
            char result = (char) asciiCode;
            // 拼接数据
            sb.append(result);
        }

        return sb.toString();
    }

    /**
     * 使用凯撒加密方式解密数据
     *
     * @param encryptedData :密文
     * @param key           :密钥
     * @return : 源数据
     */
    public static String jiemi(String encryptedData, int key) {
        // 将字符串转为字符数组
        char[] chars = encryptedData.toCharArray();
        StringBuilder sb = new StringBuilder();
        // 遍历数组
        for (char aChar : chars) {
            // 获取字符的ASCII编码
            int asciiCode = aChar;
            // 偏移数据
            asciiCode -= key;
            // 将偏移后的数据转为字符
            char result = (char) asciiCode;
            // 拼接数据
            sb.append(result);
        }

        return sb.toString();
    }
//    @Test
//    public void test(){
//        String a = jiami("wazy1314520",3);
//        System.out.println(a);
//        String b = jiemi(a,3);
//        System.out.println(b);
//    }
}
