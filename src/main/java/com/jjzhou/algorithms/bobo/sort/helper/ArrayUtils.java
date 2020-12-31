package com.jjzhou.algorithms.bobo.sort.helper;

/**
 * @author jjzhou
 * @date 2020/12/25 1:10 上午
 * @description
 */
public class ArrayUtils {

    /**
     * 数组交换
     *
     * @param nums
     * @param index1
     * @param index2
     */
    public static void swap(int[] nums, int index1, int index2) {
        assert null != nums && index1 >= 0 && index2 >= 0 && index1 < nums.length && index2 < nums.length;
        if (index1 == index2) {
            return;
        }
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
}
