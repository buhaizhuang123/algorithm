package com.bu.sort.parent.impl;

import com.bu.sort.parent.Sort;

/**
 * @author haizhuangbu
 * @date 2023/10/17 13:26
 * @mark Shell 希尔排序 减小增量排序
 */
public class Shell implements Sort {
    @Override
    public void sort(int[] arr) {
        for (int i = arr.length / 2; i >= 1; i /= 2) {

            int j = i;
            while (j < arr.length) {

                int n = j - i;

                int temp = arr[j];

                while (n >= 0 && temp < arr[n]) {
                    arr[n + i] = arr[n];
                    n -= i;
                }
                arr[n + i] = temp;
                j++;
            }
        }

    }

    @Override
    public String mark() {
        return "希尔排序";
    }

    public static void main(String[] args) {
        Shell shell = new Shell();
        shell.sort();
    }
}
