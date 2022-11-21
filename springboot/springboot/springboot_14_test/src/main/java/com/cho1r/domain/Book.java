package com.cho1r.domain;

import lombok.Data;

/**
 * Author cho1r
 * 16/2/2022 下午8:05
 */
@Data
public class Book {
    private long id;
    private String name;
    private String type;
    private String description;
}
