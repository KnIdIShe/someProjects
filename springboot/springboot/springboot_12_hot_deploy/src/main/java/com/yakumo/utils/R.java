package com.yakumo.utils;

import lombok.Data;

/**
 * Author cho1r
 * 13/2/2022 下午3:58
 */
@Data
public class R {
    private Boolean flag;
    private Object data;
    private String msg;

    public R() {
    }

    public R(Boolean flag) {
        this.flag = flag;
    }

    // 操作成功
    public R(Object data) {
        this.flag = true;
        this.data = data;
    }

    public R(Boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }
}
