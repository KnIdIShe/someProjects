package com.yakumo.pubacc.domain.button;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * Author cho1r
 * 2022/03/30 22:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PicOrPhotoButton extends AbstractButton {
    private String type = "pic_photo_or_album";
    private String key;
    private ArrayList<AbstractButton> sub_button = new ArrayList<>(0);

    public PicOrPhotoButton(String name, String key) {
        super(name);
        this.key = key;
    }
}
