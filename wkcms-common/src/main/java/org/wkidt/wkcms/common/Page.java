package org.wkidt.wkcms.common;
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
//               佛祖保佑         永无BUG  阿弥陀佛
//
//
//

import java.util.List;

/**
 * Description
 * <p>
 * Created by zcm on 2017/7/27. version 1.0
 */

public class Page<E> {
    private int currentPage;
    private int pageCount;
    private long tota;

    public Page() {
    }

    public Page(int currentPage, int pageCount, long tota, List<E> data) {
        this.currentPage = currentPage;
        this.pageCount = pageCount;
        this.tota = tota;
        this.data = data;
    }

    private List<E> data;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public long getTota() {
        return tota;
    }

    public void setTota(long tota) {
        this.tota = tota;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }

    /* extra  method */

    /**
     * 空数据
     *
     * @return
     */
    public boolean isEmpty() {
        return data != null && data.size() == 0;
    }


}
