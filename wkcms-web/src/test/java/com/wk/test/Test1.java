package com.wk.test;
//
//                       _oo0oo_
//                      o8888888o
//                      88" . "88
//                      (| -_- |)
//                      0\  =  /0
//                    ___/`---'\___
//                  .' \\|     |// '.
//                 / \\|||  :  |||// \
//                / _||||| -:- |||||- \
//               |   | \\\  -  /// |   |
//               | \_|  ''\---/''  |_/ |
//               \  .-\__  '-'  ___/-. /
//             ___'. .'  /--.--\  `. .'___
//          ."" '<  `.___\_<|>_/___.' >' "".
//         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//         \  \ `_.   \_ __\ /__ _/   .-` /  /
//     =====`-.____`.___ \_____/___.-`___.-'=====
//                       `=---='
//
//
//     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//
//               佛祖保佑         永无BUG
//
//
//

import org.apache.log4j.Logger;

import java.util.Scanner;

/**
 * Description
 * <p>
 * Created by zcm on 2017/8/3. version 1.0
 */

public class Test1 {
    public static void main(String[] args) {
        int count = 0;
        int[] arr = {22,33,77,74};
        for (int i = 0; i < arr.length; i++) {
            count++;
            for (int j = 0; j < arr.length; j++) {
                count++;
                if (compare(arr[i], arr[j])) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i : arr) { System.out.print(i); }
        System.out.println();
        System.out.println("count1 ============" + count);
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            count++;
            for (int j = i + 1; j < arr.length; j++) {
                count++;
                if (compare(arr[i], arr[j])) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i : arr) { System.out.print(i); }
        System.out.println();
        System.out.println("count2 ============" + count);
        count = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            count++;
            for (int j = 0; j < i; j++) {
                count++;
                if (compare(arr[i], arr[j])) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i : arr) { System.out.print(i); }
        System.out.println();
        System.out.println("count3 ============" + count);

    }

    private static boolean compare(int i, int j) {
        int a = Integer.parseInt(Integer.toString(i) + Integer.toString(j));
        int b = Integer.parseInt(Integer.toString(j) + Integer.toString(i));
        return a > b;
    }
}