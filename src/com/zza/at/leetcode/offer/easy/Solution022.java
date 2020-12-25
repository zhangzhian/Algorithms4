package com.zza.at.leetcode.offer.easy;

import com.zza.at.leetcode.common.ListNode;

//两个链表的第一个公共节点
public class Solution022 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
