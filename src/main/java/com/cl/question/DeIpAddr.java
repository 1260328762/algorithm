package com.cl.question;

/**
 * @author chenliang
 * @since 2021/12/1 20:34
 * <p>
 * IP 地址无效化
 * <p>
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 * <p>
 * 示例
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 * <p>
 * * 来源：力扣（LeetCode）
 * * 链接：https://leetcode-cn.com/problems/defanging-an-ip-address/
 */
public class DeIpAddr {

    public String deIpAddr(String address) {
        StringBuilder sb = new StringBuilder();

        char[] chars = address.toCharArray();
        for (char aChar : chars) {
            if (aChar == '.') {
                sb.append("[.]");
            } else {
                sb.append(aChar);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = new DeIpAddr().deIpAddr("10.20.30.50");
        System.out.println(s);
    }
}
