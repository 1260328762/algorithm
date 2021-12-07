package com.cl.question;

/**
 * @author chenliang
 * @since 2021/12/6 17:52
 * <p>
 * 判定ip地址是否合法
 * <p>
 * a.除了空格，数组和.之外不得包含其他字符
 * b.ip地址由四个数字构成，由.分隔，每个隔开的数字大小在0-255之间
 * c 数字前后可以有空格，但中间不能有空格
 * <p>
 * TODO 实现split函数
 */
public class CheckIpAddr {

    public boolean checkIpAddr(String ip) {
        if (ip == null)
            return false;

        String[] split = ip.split("\\.");
        if (split.length != 4)
            return false;

        for (int i = 0; i < split.length; i++) {
            String s = split[i];

            // 去除头部空格
            int start = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) != ' ')
                    break;
                start++;
            }

            // 全是空格，不合法
            if (start == s.length())
                return false;

            // 去除尾部空格
            int end = s.length() - 1;
            for (; end >= 0; end--) {
                if (s.charAt(end) != ' ')
                    break;
            }

            String substring = s.substring(start, end + 1);
            // 数字是否有前导0，如果有则不合法
            if (substring.length() > 1 && substring.charAt(0) == '0') {
                return false;
            }

            // 数字中间包含空格，不合法
            if (substring.contains(" "))
                return false;

            int range = Integer.parseInt(substring);
            if (range > 255 || range < 0) {
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        boolean b = new CheckIpAddr().checkIpAddr("255.255.255.255");
        System.out.println(b);
    }
}
