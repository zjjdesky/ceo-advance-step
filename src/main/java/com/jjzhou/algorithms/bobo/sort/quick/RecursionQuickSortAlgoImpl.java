package com.jjzhou.algorithms.bobo.sort.quick;

import com.jjzhou.algorithms.bobo.sort.SortAlgo;
import com.jjzhou.algorithms.bobo.sort.helper.ArrayUtils;

/**
 * @author jjzhou
 * @date 2020/12/27 3:17 下午
 * @description
 */
public class RecursionQuickSortAlgoImpl extends SortAlgo {

    public RecursionQuickSortAlgoImpl() {
        super("快速排序");
    }

    @Override
    public int[] sort(int[] nums) {
        assert null != nums && nums.length > 0;
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 对nums[l...r]之间进行快速排序
     * @param nums
     * @param l
     * @param r
     */
    private void quickSort(int[] nums, int l, int r) {
        if (l <= r) {
            return;
        }
        int p = partition(nums, l, r);
        quickSort(nums, l, p - 1);
        quickSort(nums, p + 1, r);
    }

    private int partition(int[] nums, int l, int r) {
        int flagIndex = l;
        int flag = nums[flagIndex];

        int j = l;
        // nums[l+1 ... j] < v  nums[j + 1 ... r] > v
        for (int i = l + 1; i <= r; i ++) {
            if (nums[i] < flag) {
                j ++;
                ArrayUtils.swap(nums, i, j);
            }
        }
        ArrayUtils.swap(nums, flagIndex, j);
        return j;
    }
}
