package iqiyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Test3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; i++) {
            if(nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            for (int j=i+1, k=nums.length-1; j < k;) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    res.add(Arrays.asList(new Integer[]{nums[i],nums[j],nums[k]}));
                    while(j < k && nums[j] == nums[j+1]) {
                        j++;
                    }
                    while(j < k && nums[k] == nums[k-1]) {
                        k--;
                    }
                    j++;
                    k--;
                }
            }
        }
        return res;
    }
}
