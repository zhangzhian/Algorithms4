package com.zza.at.leetcode.offer.mid;

//二叉搜索树与双向链表
public class Solution009 {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node head, pre;
    public Node treeToDoublyList(Node root) {
        if(root==null) return null;
        //可以把right理解为后继，left理解为前驱
        dfs(root);
        //进行头节点和尾节点的相互指向，顺序可以颠倒
        pre.right = head;
        head.left =pre;
        return head;
    }

    public void dfs(Node cur){
        if(cur==null) return;
        dfs(cur.left);
        //pre用于记录双向链表中位于cur左侧的节点，即上一次迭代中的cur
        //当pre==null时，cur左侧没有节点,即此时cur为双向链表中的头节点
        if(pre==null) head = cur;
        //反之，pre!=null时，cur左侧存在节点pre，需要进行pre.right=cur的操作。
        if(pre!=null) pre.right = cur;
        cur.left = pre;//pre是否为null对这句没有影响,且这句放在上面两句if else之前也是可以的。
        pre = cur;//pre指向当前的cur
        dfs(cur.right);//全部迭代完成后，pre指向双向链表中的尾节点
    }
}
