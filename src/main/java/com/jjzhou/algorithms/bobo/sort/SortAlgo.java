package com.jjzhou.algorithms.bobo.sort;

/**
 * @author jjzhou
 * @date 2020/12/25 1:02 上午
 * @description 排序算法 为了实现简单 统一升序排列
 */
public abstract class SortAlgo {

    private String sortFuncName;

    protected SortAlgo(String sortFuncName) {
        this.sortFuncName = sortFuncName;
    }

    public String getSortFuncName() {
        return sortFuncName;
    }

    /**
     * 排序
     *
     * @param nums
     * @return
     */
    public abstract int[] sort(int[] nums);

    /**
     * 只对nums在[l, r)区间进行排序
     *
     * @param nums
     * @param l
     * @param r
     * @return
     */
    protected int[] sort(int[] nums, int l, int r) {
        if (l == r) {
            return nums;
        }
        assert l < r;
        int[] subNums = new int[r - l];
        for (int i = l; i < r; i ++) {
            subNums[i - l] = nums[i];
        }
        subNums = sort(subNums);
        for (int i = l; i < r; i ++) {
            nums[i] = subNums[i - l];
        }
        return nums;
    }
}
