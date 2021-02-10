package leetcode.Num888;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int diff = (sumB - sumA) / 2;
        Set<Integer> setB = new HashSet<>();
        for (int x : B) {
            setB.add(x);
        }
        for (int x : A) {
            int objNum = x + diff;
            if (setB.contains(objNum)) {
                int[] result = {x, objNum};
                return result;
            }
        }
        return null;
    }
}