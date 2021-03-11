package com.zza.at.leetcode.offer.easy;

import com.zza.at.leetcode.common.TreeNode;

import java.util.LinkedList;

//二叉树的深度
//阿里面试原题
public class Solution003 {

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

    public static int dfs(TreeNode node){
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        return left > right ? left+1 : right+1;
    }

    public static void main(String[] args) {
        //  test
        //  TreeNode node = new TreeNode(0);
        //  node.left = new TreeNode(1);
        //  node.right = new TreeNode(2);
        //  node.right.left = new TreeNode(3);

        //  TreeNode node = new TreeNode(0);
        //  node.right = new TreeNode(2);
        //  node.right.right = new TreeNode(3);

        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.right = new TreeNode(3);
        node.right.left = new TreeNode(3);
        System.out.println(dfs(node));
    }


    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);//添加失败返回false。add抛出异常
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();//记录该层多少个节点
            while (size > 0) {
                TreeNode node = queue.poll();//失败返回null，romove异常
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;//层数加1
        }
        return ans;
    }
}
