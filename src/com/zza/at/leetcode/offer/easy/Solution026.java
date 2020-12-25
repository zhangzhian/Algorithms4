package com.zza.at.leetcode.offer.easy;

import com.zza.at.leetcode.common.ListNode;

import java.util.List;

//删除链表的节点
public class Solution026 {

    //递归
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null)
            return head;
        if (head.val == val)
            return head.next;
        head.next = deleteNode(head.next, val);
        return head;
    }

    //可以省略pre，直接用cur.next,见deleteNode2
    public ListNode deleteNode1(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode pre = null;
        ListNode cur = head;
        while (cur.val != val && cur.next != null){
            pre = cur;
            cur = cur.next;
        }
        if (cur.next == null) {
            pre.next = null;
            return head;
        }
        pre.next = pre.next.next;
        cur.next = null;
        return head;
    }

    public ListNode deleteNode2(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode cur = head;
        while (cur.next.val != val && cur.next != null){
            cur = cur.next;
        }
        if (cur.next == null) {//没找到
            return head;
        }
        cur.next = cur.next.next;
        return head;
    }
}
