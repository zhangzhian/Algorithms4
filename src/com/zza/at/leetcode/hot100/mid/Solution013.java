package com.zza.at.leetcode.hot100.mid;

import com.zza.at.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

//从前序与中序遍历序列构造二叉树
public class Solution013 {
    //用map保持索引，避免每次查找
    Map<Integer, Integer> map = new HashMap();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    TreeNode build(int[] preorder, int preStart, int preEnd,
                   int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd) return null;

        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        // rootVal 在中序遍历数组中的索引
        int index = map.get(rootVal);
        //或使用如下代码不需要占用额外空间
//        for (int i = inStart; i <= inEnd; i++) {
//            if (inorder[i] == rootVal) {
//                index = i;
//                break;
//            }
//        }
        int leftSize = index - inStart;

        // 先构造出当前根节点
        TreeNode root = new TreeNode(rootVal);
        // 递归构造左右子树
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);

        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 3};
        int[] inorder = {3, 2, 1};
        TreeNode tree = new Solution013().buildTree(preorder, inorder);
        System.out.println(tree);
    }
}
