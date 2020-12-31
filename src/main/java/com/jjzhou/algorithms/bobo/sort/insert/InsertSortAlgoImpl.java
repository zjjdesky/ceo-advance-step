package com.jjzhou.algorithms.bobo.sort.insert;

import com.jjzhou.algorithms.bobo.sort.SortAlgo;
import com.jjzhou.algorithms.bobo.sort.helper.ArrayUtils;

/**
 * 插入排序
 * @author jjzhou
 * @date 2020/12/25 1:15 上午
 * @description
 */
public class InsertSortAlgoImpl extends SortAlgo {

    public InsertSortAlgoImpl() {
        super("插入排序");
    }

    @Override
    public int[] sort(int[] nums) {
        assert null != nums && nums.length > 0;
        // 遍历到第n个 就证明前n - 1个都是有序的
        // 就是将第n个数 插入到[0..n - 1]这个里面
        for (int i = 1, len = nums.length; i < len; i ++) {
//            for (int j = i; j > 0; j --) {
//                if (nums[j] < nums[j - 1]) {
//                    ArrayUtils.swap(nums, j , j - 1);
//                } else {
//                    break;
//                }
//            }
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j --) {
                ArrayUtils.swap(nums, j , j - 1);
            }
        }
        return nums;
    }
}
