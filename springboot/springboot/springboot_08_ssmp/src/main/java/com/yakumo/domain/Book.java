package com.yakumo.domain;

import lombok.Data;

/**
 * Author cho1r
 * 12/2/2022 下午4:08
 */
@Data
public class Book {
    private long id;
    private String type;
    private String name;
    private String description;
}
