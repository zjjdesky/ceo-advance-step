package com.jjzhou.algorithms.data_structure.tree;

/**
 * @author jjzhou
 * @date 2020/8/26 9:53 下午
 * @description 最大堆
 */
public class MaxHeap {

    private int[] data;

    private int count;

    private int capacity;

    public MaxHeap(int capacity) {
        this.data = new int[capacity];
        this.capacity = capacity;
        this.count = 0;
    }

    public int[] getData() {
        return data;
    }

    public int getCount() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(int item) {
        if (count == data.length - 1) {
            int [] newData = new int[this.capacity * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        data[count++] = item;
        shiftUp(count);
    }

    public int extractMax() {
        int res = this.data[1];
        data[1] = data[count];
        count --;
        shiftDown(1);
        return res;
    }

    private void shiftDown(int index) {
        if (0 == index) {
            return;
        }
        int left = -1, right = -1;
        while ((left = 2 * index) <= count) { // 表示有左子树
            right = (2 * index + 1) <= count ? (2 * index + 1) : -1;
            if (-1 != right) { // 表示有右子树
                if (data[index] > data[left] && data[index] > data[right]) {
                    break;
                }
                int needSwapIndex = data[left] > data[right] ? left : right;
                swap(data, index, needSwapIndex);
            } else {
                if (data[index] < data[left]) {
                    swap(data, left, index);
                }
            }
            index *= 2;
        }
    }

    private void shiftUp(int index) {
        while (index > 1 && data[index / 2] < data[index]) {
            swap(data, index / 2, index);
            index /= 2;
        }
    }

    private void swap(int[] data, int index1, int index2) {
        int tmp = data[index1];
        data[index1] = data[index2];
        data[index2] = tmp;
    }


}
