package com.bu.sort.parent.impl;

import com.bu.sort.parent.Sort;

/**
 * @author haizhuangbu
 * @date 2023/10/17 13:11
 * @mark Insert 插入排序
 */
public class Insert implements Sort {
    @Override
    public void sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && temp < arr[j]) {

                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;


        }


    }

    @Override
    public String mark() {
        return "插入排序";
    }

    public static void main(String[] args) {
        Insert insert = new Insert();
        insert.sort();
    }
}
