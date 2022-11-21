package com.cho1r.controller.bak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author cho1r
 * 15/2/2022 下午3:00
 */
public class BaseClass {
    private final Class clazz;
    public static Logger log;

    public BaseClass() {
        this.clazz = this.getClass();
        log = LoggerFactory.getLogger(clazz);
    }
}
