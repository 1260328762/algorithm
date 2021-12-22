package com.cl.question.recursion;

import com.cl.question.link.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenliang
 * @since 2021/12/22 19:25
 * <p>
 * 剑指 Offer 06. 从尾到头打印链表
 * <p>
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReversePrint {

    public int[] reversePrint(ListNode head) {
        List<Integer> temp = new ArrayList<>();
        reverse(head, temp);
        return temp.stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    private void reverse(ListNode head, List<Integer> list) {
        if (head == null) {
            return;
        }
        reverse(head.next, list);

        list.add(head.val);
    }

    public static void main(String[] args) {
        ReversePrint reversePrint = new ReversePrint();
        int[] ints = reversePrint.reversePrint(ListNode.of(new int[]{1, 2, 3}));
        System.out.println(Arrays.toString(ints));
    }
}
