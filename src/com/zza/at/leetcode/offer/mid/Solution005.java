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
        //右子树根节点=(中序根节点坐标-中序左边界）+先序根节点坐标+1，其中括号内=左子树长度。
        head.right = recur(preorder,root + head_index - left + 1,head_index + 1,right);
        return head;
    }

    /**
     * @param pre_root_idx  先序遍历的索引
     * @param in_left_idx  中序遍历的索引
     * @param in_right_idx 中序遍历的索引
     */
    public TreeNode recursive(int[] preorder, int pre_root_idx, int in_left_idx, int in_right_idx) {
        //相等就是自己
        if (in_left_idx > in_right_idx) {
            return null;
        }
        //root_idx是在先序里面的
        TreeNode root = new TreeNode(preorder[pre_root_idx]);
        // 有了先序的,再根据先序的，在中序中获 当前根的索引
        int idx = dic.get(preorder[pre_root_idx]);

        //左子树的根节点就是 左子树的(前序遍历）第一个，就是+1,左边边界就是left，右边边界是中间区分的idx-1
        root.left = recursive(preorder,pre_root_idx + 1, in_left_idx, idx - 1);

        //由根节点在中序遍历的idx 区分成2段,idx 就是根

        //右子树的根，就是右子树（前序遍历）的第一个,就是当前根节点 加上左子树的数量
        // pre_root_idx 当前的根  左子树的长度 = 左子树的右边-左边(idx-1 - in_left_idx +1) 。最后+1就是右子树的根了
        root.right = recursive(preorder,pre_root_idx + (idx-1 - in_left_idx +1)  + 1, idx + 1, in_right_idx);
        return root;
    }
}
