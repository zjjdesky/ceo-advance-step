package com.jjzhou.algorithms.bobo.sort.insert;

import com.jjzhou.algorithms.bobo.sort.SortAlgo;
import com.jjzhou.algorithms.bobo.sort.helper.ArrayUtils;

/**
 * 插入排序
 * @author jjzhou
 * @date 2020/12/25 1:15 上午
 * @description
 */
public class InsertSortAlgo2Impl extends SortAlgo {

    public InsertSortAlgo2Impl() {
        super("插入排序2");
    }

    @Override
    public int[] sort(int[] nums) {
        assert null != nums && nums.length > 0;
        for (int i = 1, len = nums.length; i < len; i ++) {
            int e = nums[i];
            int j;
//            for (j = i; j > 0; j --) {
//                if (nums[j - 1] < e) {
//                    nums[j] = nums[j - 1];
//                } else {
//                    break;
//                }
//            }

            for (j = i; j > 0 && nums[j - 1] > e; j --) {
                nums[j] = nums[j - 1];
            }
            nums[j] = e;
        }
        return nums;
    }
}
