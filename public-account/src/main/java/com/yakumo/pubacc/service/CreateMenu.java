package com.yakumo.pubacc.service;

import cn.hutool.json.JSONUtil;
import com.yakumo.pubacc.domain.button.*;
import com.yakumo.pubacc.util.PaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

/**
 * Author cho1r
 * 2022/03/31 11:25
 */
@Component
public class CreateMenu {

    @Value("${create_menu_url}")
    private String create_menu_url;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PaUtil util;

    public void createMenu() {
        // 菜单对象
        Button button = new Button();
        ArrayList<AbstractButton> buttons = button.getButton();
        // 第一个一级菜单
        buttons.add(new ClickButton("Click", "11"));
        // 第二个一级菜单
        buttons.add(new ViewButton("Bing", "https://www.bing.com"));
        // 第三个菜单的子菜单
        SubButton subButton = new SubButton("Other");
        ArrayList<AbstractButton> sub_button = subButton.getSub_button();
        sub_button.add(new PicOrPhotoButton("图片文字识别", "31"));
        sub_button.add(new ClickButton("Click", "32"));
        sub_button.add(new ViewButton("网易新闻", "https://www.163.com"));
        // 第三个菜单加入子菜单
        buttons.add(subButton);
        // Button to json
        String jsonStr = JSONUtil.toJsonStr(button);
        System.out.println(jsonStr);
        // 获取 accessToken
        String accessToken = util.getAccessToken();
        // 发送新建菜单的请求
        String resp = restTemplate.postForObject(create_menu_url + accessToken, jsonStr, String.class);
        System.out.println(resp);
    }
}
