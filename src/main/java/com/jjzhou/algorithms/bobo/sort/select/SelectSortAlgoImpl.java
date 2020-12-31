package com.jjzhou.algorithms.bobo.sort.select;

import com.jjzhou.algorithms.bobo.sort.SortAlgo;
import com.jjzhou.algorithms.bobo.sort.helper.ArrayUtils;

/**
 * 选择排序的主要思想就是每次都去选择一个最小的
 * 然后将选择后的数据与当前循环开始的元素进行交换
 * 复杂度是O(n^2)
 * @author jjzhou
 * @date 2020/12/25 1:04 上午
 * @description 选择排序
 */
public class SelectSortAlgoImpl extends SortAlgo {

    public SelectSortAlgoImpl() {
        super("选择排序");
    }

    @Override
    public int[] sort(int[] nums) {
        assert nums != null && nums.length > 0;
        for (int i = 0, len = nums.length; i < len; i ++) {
            // 寻找[i, len]的最小值
            int minIndex = i;
            for (int j = i + 1; j < len; j ++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            ArrayUtils.swap(nums, minIndex, i);
        }
        return nums;
    }
}
