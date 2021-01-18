package com.zza.at.leetcode.hot100.mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//电话号码的字母组合
public class Solution033 {

    //一个映射表，第二个位置是"abc“,第三个位置是"def"。。。
    //这里也可以用map，用数组可以更节省点内存
    String[] letter_map = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        //注意边界条件
        if(digits==null || digits.length()==0) {
            return new ArrayList<>();
        }
        iterStr(digits, new StringBuilder(), 0);
        return res;
    }
    //最终输出结果的list
    List<String> res = new ArrayList<>();

    //递归函数
    private void iterStr(String str, StringBuilder letter, int index) {
        //递归的终止条件
        //用index记录每次遍历到字符串的位置
        if(index == str.length()) {
            res.add(letter.toString());
            return;
        }
        //获取index位置的字符，假设输入的字符是"234"
        //第一次递归时index为0所以c=2，第二次index为1所以c=3，第三次c=4
        //subString每次都会生成新的字符串，而index则是取当前的一个字符，所以效率更高一点
        char c = str.charAt(index);
        //map_string的下表是从0开始一直到9， c-'0'就可以取到相对的数组下标位置
        //比如c=2时候，2-'0'，获取下标为2,letter_map[2]就是"abc"
        int pos = c - '0';
        String map_string = letter_map[pos];
        //遍历字符串，比如第一次得到的是2，页就是遍历"abc"
        for(int i=0;i<map_string.length();i++) {
            //调用下一层递归
            letter.append(map_string.charAt(i));
            iterStr(str, letter, index+1);
            //回溯
            letter.deleteCharAt(letter.length()-1);
        }
    }


    public List<String> letterCombinations1(String digits) {
        if(digits==null || digits.length()==0) {
            return new ArrayList<String>();
        }
        //一个映射表，第二个位置是"abc“,第三个位置是"def"。。。
        //这里也可以用map，用数组可以更节省点内存
        String[] letter_map = {
                " ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        List<String> res = new ArrayList<>();
        //先往队列中加入一个空字符
        res.add("");
        for(int i=0;i<digits.length();i++) {
            //由当前遍历到的字符，取字典表中查找对应的字符串
            String letters = letter_map[digits.charAt(i)-'0'];
            int size = res.size();
            //计算出队列长度后，将队列中的每个元素挨个拿出来
            for(int j=0;j<size;j++) {
                //每次都从队列中拿出第一个元素
                String tmp = res.remove(0);
                //然后跟"def"这样的字符串拼接，并再次放到队列中
                for(int k=0;k<letters.length();k++) {
                    res.add(tmp+letters.charAt(k));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //List<String> list = new Solution033().letterCombinations("234");
        List<String> list = new Solution033().letterCombinations1("23");
        for (String str : list) {
            System.out.println(str);
        }
    }
}
