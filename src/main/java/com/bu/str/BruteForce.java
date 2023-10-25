package com.bu.str;

/**
 * @author haizhuangbu
 * @date 2023/10/25 16:50
 * @mark BruteForce 暴力算法
 */
public class BruteForce {


    public void bruteForce(String[] str, String[] sm) {

        for (int i = 0; i < str.length; i++) {

            for (int j = 0; j < sm.length; j++) {
                if (!str[i + j].equals(sm[j])) {
                    break;
                }
                if (j == sm.length - 1) {
                    System.out.println(" 匹配成功 i :" + i + " j : " + (i + j));
                }
            }

        }


    }

    public static void main(String[] args) {
        BruteForce bruteForce = new BruteForce();
        String[] str = {"a", "b", "c", "a", "b", "C"};
        String[] sm = {"a", "b", "C"};
        bruteForce.bruteForce(str, sm);

    }

}
