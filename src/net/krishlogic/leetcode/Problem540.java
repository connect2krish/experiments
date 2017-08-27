package net.krishlogic.leetcode;

/**
 * Created by kvenkat on 5/16/17.
 */
public class Problem540 {

    public static int singleNonDuplicate(int[] nums) {
        int size = nums.length;

        if (size ==1) {
            return nums[0];
        }

        if (size == 2) {
            if (nums[0] < nums[1]) {
                return nums[0];
            } else if(nums[0] == nums[1]) {
                throw new RuntimeException("not found");
            }
        }

        if (size > 2) {
            if (nums[0] < nums[1]) {
                return nums[0];
            }
        }

        if (nums[size-1] > nums[size-2]) {
            return nums[nums.length-1];
        }

        for (int i=1; i<nums.length; i++) {
            if (i+1 <= nums.length) {
                if ((nums[i-1] < nums[i]) && nums[i] < nums[i+1]) {
                    return nums[i];
                }
            }
        }

        return nums[0];

    }

    public static void main(String args[]) {
        int test[] = {1,1,2};
        System.out.println(Problem540.singleNonDuplicate(test));
    }
}

