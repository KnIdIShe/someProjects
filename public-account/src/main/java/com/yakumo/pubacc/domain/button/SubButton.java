package com.yakumo.pubacc.domain.button;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * Author cho1r
 * 2022/03/30 22:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubButton extends AbstractButton {
    private ArrayList<AbstractButton> sub_button = new ArrayList<>();

    public SubButton(String name) {
        super(name);
    }
}
