package com.zza.at.leetcode.offer.easy;

import com.zza.at.leetcode.common.ListNode;

//反转链表
public class Solution008 {

    //递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    //遍历
    public ListNode reverseList1(ListNode head) {
        if (head == null) return null;
        ListNode curr = head;
        ListNode pre = null;
        ListNode temp;
        while (curr != null){
            temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }
}
