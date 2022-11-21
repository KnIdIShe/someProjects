package com.yakumo.pubacc.domain.sendMsg;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Author cho1r
 * 2022/03/30 14:41
 */
@Data
@AllArgsConstructor
@XStreamAlias("item")
public class Article {
    @XStreamAlias("Title")
    private String title;

    @XStreamAlias("Description")
    private String description;

    @XStreamAlias("PicUrl")
    private String picUrl;

    @XStreamAlias("Url")
    private String url;
}
