package com.itheima.springboot_01_ssm_startquick.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCheckUtil {

    /** 是否为手机号
     * @param mobileNo
     * @return
     */
    public static boolean isMobile(String mobileNo) {
        String regex = "[1][0-9]{10}";
        return mobileNo.matches(regex);
    }

    /** 是否为邮箱地址
     * @param email
     * @return
     * 备注：复制正则表达式\\，会自动加\\\\，粘贴之后需去除\\
     */
    public static boolean isEmail(String email) {
        String regex = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /** 校验字符串中是否含有数组中存储的关键字符串(忽略大小写)
     * @param keywords
     * @param input
     * @return
     */
    public static boolean isExist(String input, String[] keywords) {
        if (keywords.length <= 0) {
            return false;
        }
        for (String keyword : keywords) {
            if (input.toLowerCase().contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /** 判断输入的字符串参数是否为空
     * StringCheckUtil.isEmpty(null)      = true
     * StringCheckUtil.isEmpty("")        = true
     * StringCheckUtil.isEmpty(" ")       = true
     * StringCheckUtil.isEmpty("bob")     = flase
     * StringCheckUtil.isEmpty("  bob  ") = flase
     * @return boolean 空则返回true,非空则flase
     */
    public static boolean isEmpty(String input) {
        return null == input || 0 == input.length() || 0 == input.replaceAll("\\s", "").length();
    }

    /** 判断输入的字节数组是否为空
     *
     * @return boolean 空则返回true,非空则flase
     */
    public static boolean isBlank(byte[] bytes) {
        return null == bytes || 0 == bytes.length;
    }
}
