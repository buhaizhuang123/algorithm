package com.bu.sort.parent.impl;

import com.bu.sort.parent.Sort;

/**
 * @author haizhuangbu
 * @date 2023/10/17 14:02
 * @mark Counter
 */
public class Counter implements Sort {
    @Override
    public void sort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) max = arr[i];
        }

        int[] counter = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            counter[arr[i]] += 1;
        }


        for (int i = 1; i < counter.length; i++) {
            counter[i] += counter[i - 1];
        }

        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int ix = counter[arr[i]] - 1;
            temp[ix] = arr[i];
            counter[arr[i]] -= 1;
        }


        for (int i = 0; i < temp.length; i++) {
            arr[i] = temp[i];
        }


    }

    @Override
    public String mark() {
        return "计数排序";
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.sort();
    }
}
