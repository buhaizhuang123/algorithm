package com.bu.sort.parent.impl;

import com.bu.sort.parent.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haizhuangbu
 * @date 2023/10/17 14:32
 * @mark Cardinal 基数排序
 */
public class Cardinal implements Sort {
    @Override
    public void sort(int[] arr) {

        List<Integer>[] cardinal = new ArrayList[10];

        for (int i = 0; i < cardinal.length; i++) {
            cardinal[i] = new ArrayList<>();
        }

        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) max = arr[i];
        }

        String base = String.valueOf(max);

        int cnt = base.length();

        while (cnt >= 0) {


            // 入桶
            for (int i = 0; i < arr.length; i++) {

                int val = (int) (arr[i] % Math.pow(10, cnt) / 10);
                cardinal[val].add(arr[i]);

            }

            // 桶内元素排序
            for (int i = 0; i < cardinal.length; i++) {
                cardinal[i].sort(null);
            }


            // 出桶
            int tmp = 0;
            for (int i = 0; i < cardinal.length; i++) {
                for (int j = 0; j < cardinal[i].size(); j++) {
                    arr[tmp] = cardinal[i].get(j);
                    tmp++;
                }
                cardinal[i].clear();
            }


            cnt--;
        }


    }

    @Override
    public String mark() {
        return "基数排序";
    }


    public static void main(String[] args) {
        Cardinal cardinal = new Cardinal();
        cardinal.sort();
    }
}
