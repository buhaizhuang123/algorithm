package com.bu.sort.parent.impl;

import com.bu.sort.parent.Sort;

import java.util.ArrayList;

/**
 * @author haizhuangbu
 * @date 2023/10/17 13:47
 * @mark Bucket 桶排序
 */
public class Bucket implements Sort {
    @Override
    public void sort(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) max = arr[i];
            if (min > arr[i]) min = arr[i];
        }

        int size = (max - min) / arr.length;
        int cnt = (max - min) / size + 1;

        ArrayList<Integer>[] arrayLists = new ArrayList[cnt];
        for (int i = 0; i < arrayLists.length; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        // 入桶
        for (int i = 0; i < arr.length; i++) {
            int idx = (arr[i] - min) / size;
            arrayLists[idx].add(arr[i]);
        }

        // 桶内元素排序
        for (int i = 0; i < arrayLists.length; i++) {
            arrayLists[i].sort(null);
        }

        int temp = 0;
        for (int i = 0; i < arrayLists.length; i++) {
            for (int j = 0; j < arrayLists[i].size(); j++) {
                arr[temp++] = arrayLists[i].get(j);
            }
        }

    }

    @Override
    public String mark() {
        return "桶排序";
    }


    public static void main(String[] args) {
        Bucket bucket = new Bucket();
        bucket.sort();
    }
}
