package com.bu.sort.parent.impl;

import com.bu.sort.comm.AriUtils;
import com.bu.sort.parent.Sort;

/**
 * @author haizhuangbu
 * @date 2023/10/17 11:28
 * @mark Select
 */
public class Select implements Sort {
    /**
     * @param arr 排序数组
     *            不进行元素递归替换,每一轮找到最小值
     */
    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            AriUtils.swap(arr, min, i);
        }


    }

    @Override
    public String mark() {
        return "选择排序";
    }

    public static void main(String[] args) {
        Select select = new Select();
        select.sort();
    }
}
