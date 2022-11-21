package com.yakumo.pubacc.domain.button;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author cho1r
 * 2022/03/30 22:25
 */
@Data
@NoArgsConstructor
public class ClickButton extends AbstractButton {
    private String type = "click";
    private String key;

    public ClickButton(String name, String key) {
        super(name);
        this.key = key;
    }
}
