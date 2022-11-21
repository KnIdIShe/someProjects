package com.yakumo.pubacc.domain.button;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * Author cho1r
 * 2022/03/30 22:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Button {
    private ArrayList<AbstractButton> button = new ArrayList<>();
}
