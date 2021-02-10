package jzoffer.num45;

import java.util.*;

// TODO 未解决
//  见题解 https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/solution/mian-shi-ti-45-ba-shu-zu-pai-cheng-zui-xiao-de-s-4/
//  排序时 只要考虑字符串 x+y 和 y+x 的大小即可
class Solution {
    public String minNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int x : nums) {
            list.add(x);
        }
        Collections.sort(list, c);
        StringBuffer sb = new StringBuffer();
        for (int x : list) {
            sb.append(x);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
//        list.add(3);
//        list.add(30);
        list.add(34);
        list.add(5);
//        list.add(9);
        Collections.sort(list, c);
        System.out.println(list);
    }

    static Comparator<Integer> c = (a0, a1) -> {
        Integer s1 = (Integer) a0;
        Integer s2 = (Integer) a1;
        String str1 = String.valueOf(s1);
        String str2 = String.valueOf(s2);
        return (str1 + str2).compareTo(str2 + str1);
    };
}
