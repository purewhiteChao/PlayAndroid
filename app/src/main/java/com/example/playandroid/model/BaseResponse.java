package com.example.playandroid.model;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/10 0010
 * Time: 21:24
 * Describe: ${as}
 */
public class BaseResponse<T> {
        /**
         * data : []
         * errorCode : 0
         * errorMsg :
         */

        //errorCode = 0代表执行成功，非0都为失败
        //errorCode = -1001 代表登录失效，需要重新登录。
        private int errorCode;
        private String errorMsg;
        private T data;

        public int getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }

        public String getErrorMsg() {
            return errorMsg;
        }

        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
}
