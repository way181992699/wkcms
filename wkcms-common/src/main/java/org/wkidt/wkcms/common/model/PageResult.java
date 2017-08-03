package org.wkidt.wkcms.common.model;
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

/**
 * Description
 * <p>
 * Created by zcm on 2017/7/27. version 1.0
 */

public class PageResult<E> extends Result<Page<E>> {

	private static final long serialVersionUID = 1L;

	public PageResult() {
    }

    public PageResult(int status, String message) {
        super(status, message);
    }

    public PageResult(int status, String message, Page<E> data) {
        super(status, message, data);
    }

}
