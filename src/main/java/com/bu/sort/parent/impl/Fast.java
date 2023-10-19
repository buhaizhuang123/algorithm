package com.bu.sort.parent.impl;

import com.bu.sort.comm.AriUtils;
import com.bu.sort.parent.Sort;

import java.util.Arrays;
import java.util.Properties;

/**
 * @author haizhuangbu
 * @date 2023/10/17 15:08
 * @mark Fast 快速排序
 */
public class Fast implements Sort {
    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = findMid(arr, left, right);
        sort(arr, left, mid - 1);
        sort(arr, mid + 1, right);
    }

    private int findMid(int[] arr, int left, int right) {
        int provid = right;
        int s1 = left;
        for (int s2 = left; s2 < right; s2++) {
            if (arr[s2] < arr[provid]) AriUtils.swap(arr, s1++, s2);
        }
        AriUtils.swap(arr, s1, provid);

        return s1;
    }

    @Override
    public String mark() {
        return "快速排序";
    }

    public static void main(String[] args) {
        Fast fast = new Fast();
        fast.sort();
        Properties properties = System.getProperties();
        Arrays.stream(properties.toString().split(","))
                .forEach(System.out::println);
    }
}
