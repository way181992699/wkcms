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
//               佛祖保佑         永无BUG
//
//
//

import java.io.Serializable;

/**
 * Description
 * <p>
 * Created by zcm on 2017/7/27. version 1.0
 */

public class Result<E> implements Serializable {

    public static final int STATUS_SUCCESS = 1; //陈功
    public static final int STATUS_ERROR = 2;//错误
    public static final int STATUS_UNKNOW = 3;//未知错误
    public static final int STATUS_UNAUTH = 4;//未授权，没有权限
    public static final int STATUS_UNLOGIN = 5;//未登录

    //*************************************************************
    //*************************************************************
    //*************************************************************
    public static final String MESSAGE_SUCCESS = "操作成功";
    public static final String MESSAGE_ERROR = "操作失败";
    public static final String MESSAGE_UNKNOW = "未知错误";
    public static final String MESSAGE_UNAUTH = "没有该权限";
    public static final String MESSAGE_UNLOGIN = "该用户未登录";

    //*************************************************************
    //*************************************************************
    //*************************************************************
    private int status;
    private String message;
    private E data;

    public Result() {
    }

    public Result(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public Result(int status, String message, E data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
