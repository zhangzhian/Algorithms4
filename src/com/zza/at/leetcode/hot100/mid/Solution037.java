package com.zza.at.leetcode.hot100.mid;

import java.util.LinkedList;

//字符串解码
public class Solution037 {
    public String decodeString(String s) {
        //保存已拼接好的字符串
        StringBuilder res = new StringBuilder();
        //数字字符，字符串出现次数
        int multi = 0;
        //辅助栈
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for(Character c : s.toCharArray()) {
            //将当前multi和res入栈
            //multi和res置0
            if(c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            }
            //出栈
            else if(c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                //生成字符串
                for(int i = 0; i < cur_multi; i++) tmp.append(res);
                //拼接，保存
                res = new StringBuilder(stack_res.removeLast() + tmp);
            }
            //数字可能不止一位
            else if(c >= '0' && c <= '9') multi = multi * 10 + Integer.parseInt(c + "");
            //字符直接加入结果
            else res.append(c);
        }
        return res.toString();
    }


    public static void main(String[] args) {
        //输入：s = "2[abc]3[cd]ef"
        //输出："abcabccdcdcdef"
        System.out.println(new Solution037().decodeString("2[abc]3[cd]ef"));
        System.out.println(new Solution037().decodeString("abc3[cd]ef"));
    }
}
