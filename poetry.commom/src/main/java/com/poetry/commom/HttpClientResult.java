package com.poetry.commom;

public class HttpClientResult {

        /**
         * 响应状态码
         */
        private int code;

        /**
         * 响应数据
         */
        private String content;

        protected HttpClientResult(int code, String content){
            this.code=code;
            this.content=content;
        }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
