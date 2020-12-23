package com.zza.at.leetcode.offer.easy;

import com.zza.at.leetcode.common.ListNode;

//合并两个排序的链表
public class Solution010 {

    //递归，从尾部到头部
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val > l2.val) {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }else {
            l1.next = mergeTwoLists(l2,l1.next);
            return l1;
        }
    }

    //迭代，从头部到尾部
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        return prehead.next;
    }
}
