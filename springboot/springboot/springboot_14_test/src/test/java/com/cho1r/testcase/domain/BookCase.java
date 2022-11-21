package com.cho1r.testcase.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Author cho1r
 * 17/2/2022 下午5:36
 */
@Data
@Component
@ConfigurationProperties("testcase.book")
public class BookCase {
    private int id;
    private int id2;
    private String name;
    private String uuid;
    private long publishTime;
}
