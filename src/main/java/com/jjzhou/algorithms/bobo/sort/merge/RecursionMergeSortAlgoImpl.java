package com.jjzhou.algorithms.bobo.sort.merge;

import com.jjzhou.algorithms.bobo.sort.SortAlgo;

/**
 * @author jjzhou
 * @date 2020/12/25 1:19 上午
 * @description
 */
public class RecursionMergeSortAlgoImpl extends SortAlgo {

    public RecursionMergeSortAlgoImpl() {
        super("归并排序（递归）");
    }

    /**
     *   [2 3 5 1]      [6 7 9 1]
     *   [2 3] [5 1]    [6 7] [9 1]
     *   [2][3][5][1]   [6][7][9][1]
     *
     *   [2 3][1 5]    [6 7] [1 9]
     *   [1 2 3 5]     [1 6 7 9]
     *
     *   a[2 3] b[1 5]
     *   [1 2 3 5]
     *
     *   O(NlgN)
     *  a  2 3 4   index = 2
     *  b  1 5 7   index = 2
     *  ab 1, 2, 3, 4, 5, 7
     * @param nums
     * @return
     */
    @Override
    public int[] sort(int[] nums) {
        assert null != nums && nums.length > 0;
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 对于[l, r]之间进行排序
     * @param nums o, n - 1
     * @param l
     * @param r
     */
    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2; // mid = (l + r) / 2
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        // a [1 2 3 4 ] b [5 6 7 8]
        merge(nums, l, mid, r);
    }

    /**
     * 将nums[l, mid] 与nums[mid + 1, r]进行归并
     * @param nums
     * @param l
     * @param mid
     * @param r
     */
    private void merge(int[] nums, int l, int mid, int r) {
        int[] newArr = new int[r - l + 1];
        for (int i = l; i <= r; i ++) {
            newArr[i - l] = nums[i];
        }
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k ++) {
            if (i > mid) {
                nums[k] = newArr[j - l];
                j ++;
            } else if (j > r){
                nums[k] = newArr[i - l];
                i ++;
            } else if (newArr[i - l] < newArr[j - l]) {
                nums[k] = newArr[i - l];
                i ++;
            } else {
                nums[k] = newArr[j - l];
                j ++;
            }
        }
    }
}
