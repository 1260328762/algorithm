package com.cl.question.recursion;

import com.cl.question.link.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenliang
 * @since 2021/12/22 19:25
 */
public class ReversePrint {

    public int[] reversePrint(ListNode head) {
        List<Integer> temp = new ArrayList<>();
        reverse(head, temp);

        return null;
    }

    private void reverse(ListNode head, List<Integer> list) {
        if (head.next == null) {
            list.add(head.val);
            return;
        }

        reverse(head.next, list);
    }

    public static void main(String[] args) {
        ReversePrint reversePrint = new ReversePrint();
        reversePrint.reversePrint(ListNode.of(new int[]{1, 2, 3}));
    }
}
