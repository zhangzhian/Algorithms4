package com.zza.at.leetcode.offer.easy;

import com.zza.at.leetcode.common.ListNode;

//链表中倒数第k个节点
public class Solution004 {
    //双指针
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return head;
        ListNode temp = head;
        while (k-- > 0){
            head = head.next;
        }

        while (head != null){
            temp = temp.next;
            head = head.next;
        }
        return temp;
    }

    //递归
    int size;
    public ListNode getKthFromEnd1(ListNode head, int k){
        if (head == null) return head;
        ListNode node = getKthFromEnd1(head.next, k);
        if (++size == k)
            return head;
        return node;
    }

    public static void main(String[] args) {

    }
}
