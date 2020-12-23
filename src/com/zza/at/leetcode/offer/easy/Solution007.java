package com.zza.at.leetcode.offer.easy;

import com.zza.at.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;

//从尾到头打印链表
public class Solution007 {

    int[] res = null;
    int len = 0;
    int pos = 0;
    public int[] reversePrint(ListNode head) {
        if (head == null) return res = new int[len];
        len++;
        reversePrint((head.next));
        res[pos++] = head.val;
        return res;
    }


    //使用ArrayList辅助
    ArrayList<Integer> tmp = new ArrayList<Integer>();
    public int[] reversePrint1(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = tmp.get(i);
        return res;
    }
    void recur(ListNode head) {
        if(head == null) return;
        recur(head.next);
        tmp.add(head.val);
    }

    //辅助栈法
    public int[] reversePrint2(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while (head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = stack.removeLast();
        return res;
    }
}
