package com.jjzhou.algorithms.bobo.sort.helper;

import com.jjzhou.algorithms.bobo.sort.SortAlgo;

import java.util.Random;

/**
 * @author jjzhou
 * @date 2020/12/27 1:46 下午
 * @description
 */
public class SortTestHelper {

    /**
     * 生成元素为n，范围在[rangeL, rangeR]区间的数组
     * @param n
     * @param rangeL
     * @param rangeR
     * @return
     */
    public static int[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert n > 0 && rangeL > 0 && rangeL <= rangeR;
        int[] nums = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i ++) {
            nums[i] = random.nextInt() % (rangeR - rangeL + 1) + rangeL;
        }
        return nums;
    }

    /**
     * 是否升序
     * @param arr
     * @return
     */
    public static boolean isSorted(int[] arr) {
        assert null != arr;
        if (arr.length < 2) {
            return true;
        }
        for (int i = 1, len = arr.length; i < len; i ++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 测试算法耗时
     *
     * @param algo
     * @param arr
     */
    public static void testAlgo(SortAlgo algo, int[] arr) {
        assert null != algo;
        long start = System.currentTimeMillis();
        arr = algo.sort(arr);
        long end = System.currentTimeMillis();
        assert isSorted(arr);
        System.out.printf("【%s】耗时：%d ms%n", algo.getSortFuncName(), end - start);
    }

    /**
     * 拷贝数组
     *
     * @param arr
     * @return
     */
    public static int[] copyIntArray(int[] arr) {
        assert arr != null;
        int[] newArr = new int[arr.length];
        for (int i = 0, len = arr.length; i < len; i ++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    /**
     * 生成近乎有序的数组
     *
     * @param n
     * @param swapTimes
     * @return
     */
    public static int[] generateNearlyOrderedArray(int n, int swapTimes) {
        assert n > 0 && swapTimes > 0;
        int[] nums = new int[n];
        for (int i = 0; i < n; i ++) {
            nums[i] = n;
        }
        Random random = new Random();
        for (int i = 0; i < swapTimes; i ++) {
            int index1 = Math.abs(random.nextInt()) % n;
            int index2 = Math.abs(random.nextInt()) % n;
            ArrayUtils.swap(nums, index1, index2);
        }
        return nums;
    }
}
