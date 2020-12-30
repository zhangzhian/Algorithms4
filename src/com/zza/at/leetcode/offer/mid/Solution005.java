package com.zza.at.leetcode.offer.mid;

import com.zza.at.leetcode.common.TreeNode;

import java.util.HashMap;

//重建二叉树
public class Solution005 {
    HashMap<Integer, Integer> dic = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(preorder,0,0,inorder.length-1);
    }

    public TreeNode recur(int[] preorder, int root, int left, int right) {
        if(left > right) return null;
        int head_val = preorder[root];
        int head_index = dic.get(head_val);
        TreeNode head = new TreeNode(head_val);
        head.left = recur(preorder,root + 1, left, head_index - 1);
        head.right = recur(preorder,root + head_index - left + 1,head_index + 1,right);
        return head;
    }
}
