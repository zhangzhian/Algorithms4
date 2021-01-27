package com.zza.at.leetcode.offer.mid;

import com.zza.at.leetcode.common.TreeNode;

//树的子结构
public class Solution023 {

    //遍历A树的节点，判断节点对于的子树是否包含B树
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null)
                && (recur(A, B)                 //A包含B
                || isSubStructure(A.left, B)    //A的左子树包含B
                || isSubStructure(A.right, B)); //A的右子树包含B
    }

    //判断以A树包含B
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

}
