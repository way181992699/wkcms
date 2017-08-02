package andorid.test;
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

/**
 * Description
 * <p>
 * Created by zcm on 2017/8/2. version 1.0
 */

public class Test3 {
    static Logger logger = Logger.getLogger(Test3.class);

    public static void main(String[] args) {
        int[] arr = {40, 3, 15, 57, 86, 68, 98};
        quick(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + "   ");
        }
    }

    private static void quick(int[] arr, int i, int j) {
        if (i < j) {
            int n = sort(arr, i, j);
            //递归
            quick(arr, i, n - 1);
            quick(arr, n + 1, j);
        }
    }

    private static int sort(int[] arr, int i, int j) {
        // TODO Auto-generated method stub
        logger.info(i + "  :  " + j);
        int sum = arr[i];
        while (i < j) {
            while (i < j && arr[j] >= sum) {
                j--;
            }
            arr[i] = arr[j];
            while (i < j && arr[i] <= sum) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = sum;
        return i;
    }

}
