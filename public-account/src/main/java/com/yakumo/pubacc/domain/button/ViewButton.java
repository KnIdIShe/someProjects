package com.yakumo.pubacc.domain.button;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author cho1r
 * 2022/03/30 22:25
 */
@Data
@NoArgsConstructor
public class ViewButton extends AbstractButton {
    private String type = "view";
    private String url;

    public ViewButton(String name, String url) {
        super(name);
        this.url = url;
    }
}
