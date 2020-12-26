package com.zza.at.leetcode.hot100.mid;

//寻找重复数
public class Solution016 {
    public int findDuplicate(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i]-1 != i){
                //索引 与 索引对应的值 相等， 该数字已经存在了
                if(nums[i] == nums[nums[i] -1]){
                    return nums[i];
                }
                temp=nums[i];
                nums[i]=nums[temp -1];
                nums[temp-1]=temp;
            }
        }
        return -1;
    }

    public int findDuplicate1(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        //[2,5,9,6,9,3,8,9,7,1]
        //[1,3,4,2,2]
        //[3,1,3,4,2]
        int ret = new Solution016().findDuplicate1(new int[]{2,5,9,6,9,3,8,9,7,1});
        System.out.println(ret);
    }
}
