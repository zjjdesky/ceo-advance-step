package com.jjzhou.algorithms.bobo.sort.main;

import com.jjzhou.algorithms.bobo.sort.helper.SortTestHelper;
import com.jjzhou.algorithms.bobo.sort.insert.InsertSortAlgo2Impl;
import com.jjzhou.algorithms.bobo.sort.insert.InsertSortAlgoImpl;
import com.jjzhou.algorithms.bobo.sort.merge.RecursionMergeSortAlgo2Impl;
import com.jjzhou.algorithms.bobo.sort.merge.RecursionMergeSortAlgo3Impl;
import com.jjzhou.algorithms.bobo.sort.merge.RecursionMergeSortAlgoImpl;
import com.jjzhou.algorithms.bobo.sort.quick.RecursionQuickSortAlgoImpl;
import com.jjzhou.algorithms.bobo.sort.select.SelectSortAlgoImpl;
import org.junit.Test;

/**
 * @author jjzhou
 * @date 2020/12/27 2:13 下午
 * @description
 */
public class TestSort {

    @Test
    public void testSelectAndInsertAlgo() {
        int[] arr1 = SortTestHelper.generateRandomArray(100000, 1, 100000);
        int[] arr2 = SortTestHelper.copyIntArray(arr1);
        int[] arr3 = SortTestHelper.copyIntArray(arr1);

        SortTestHelper.testAlgo(new SelectSortAlgoImpl(), arr1);
        SortTestHelper.testAlgo(new InsertSortAlgoImpl(), arr2);
        SortTestHelper.testAlgo(new InsertSortAlgo2Impl(), arr3);
    }

    @Test
    public void testSelectAndInsertAlgoWithArrayNearlyOrderly() {
        int[] arr1 = SortTestHelper.generateNearlyOrderedArray(100000, 10);
        int[] arr2 = SortTestHelper.copyIntArray(arr1);
        int[] arr3 = SortTestHelper.copyIntArray(arr1);

        SortTestHelper.testAlgo(new SelectSortAlgoImpl(), arr1);
        SortTestHelper.testAlgo(new InsertSortAlgoImpl(), arr2);
        SortTestHelper.testAlgo(new InsertSortAlgo2Impl(), arr3);
    }

    @Test
    public void testInsertAndMergeAlgo() {
        int[] arr1 = SortTestHelper.generateRandomArray(100000, 1, 100000);
        int[] arr2 = SortTestHelper.copyIntArray(arr1);

        SortTestHelper.testAlgo(new InsertSortAlgo2Impl(), arr1);
        SortTestHelper.testAlgo(new RecursionMergeSortAlgoImpl(), arr2);
    }

    @Test
    public void testInsertAndMergeAlgoWithArrayNearlyOrderly() {
        int[] arr1 = SortTestHelper.generateNearlyOrderedArray(1000000,10);
        int[] arr2 = SortTestHelper.copyIntArray(arr1);
        int[] arr3 = SortTestHelper.copyIntArray(arr1);
        int[] arr4 = SortTestHelper.copyIntArray(arr1);

        SortTestHelper.testAlgo(new InsertSortAlgo2Impl(), arr1);
        SortTestHelper.testAlgo(new RecursionMergeSortAlgoImpl(), arr2);
        SortTestHelper.testAlgo(new RecursionMergeSortAlgo2Impl(), arr3);
        SortTestHelper.testAlgo(new RecursionMergeSortAlgo3Impl(), arr4);
    }


    @Test
    public void testInsert_Merge_QuickSortAlgo() {
        int[] arr1 = SortTestHelper.generateRandomArray(100000, 1, 100000);
        int[] arr2 = SortTestHelper.copyIntArray(arr1);
        int[] arr3 = SortTestHelper.copyIntArray(arr1);

        SortTestHelper.testAlgo(new InsertSortAlgo2Impl(), arr1);
        SortTestHelper.testAlgo(new RecursionMergeSortAlgo3Impl(), arr2);
        SortTestHelper.testAlgo(new RecursionQuickSortAlgoImpl(), arr3);
    }

}
