package com.bu.sort.parent.impl;

import com.bu.sort.parent.Sort;

/**
 * @author haizhuangbu
 * @date 2023/10/17 13:36
 * @mark Merger 归并排序
 */
public class Merger implements Sort {
    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public void sort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];
        int s1 = left;
        int s2 = mid + 1;
        int idx = 0;
        while (s1 <= mid && s2 <= right) {
            if (arr[s1] < arr[s2]) {
                temp[idx++] = arr[s1++];
            } else {
                temp[idx++] = arr[s2++];
            }
        }

        while (s1 <= mid) {
            temp[idx++] = arr[s1++];
        }

        while (s2 <= right) {
            temp[idx++] = arr[s2++];
        }

        for (int i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }


    }


    @Override
    public String mark() {
        return "归并排序";
    }

    public static void main(String[] args) {
        Merger merger = new Merger();
        merger.sort();
    }
}
