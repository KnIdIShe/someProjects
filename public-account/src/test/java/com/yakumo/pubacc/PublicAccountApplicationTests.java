package com.yakumo.pubacc;

import com.yakumo.pubacc.service.CreateMenu;
import com.yakumo.pubacc.service.TemplateMsgService;
import com.yakumo.pubacc.service.Upload;
import com.yakumo.pubacc.util.PaUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PublicAccountApplicationTests {

    @Autowired
    private PaUtil util;

    @Autowired
    private TemplateMsgService templateMsgService;

    @Autowired
    private Upload upload;

    @Autowired
    private CreateMenu createMenu;

    @Test
    void t1() {
        System.out.println(util.getAccessToken());
        System.out.println(util.getAccessToken());
    }

    /**
     * 创建菜单
     */
    @Test
    void t6() {
        createMenu.createMenu();
    }

    /**
     * 模板消息相关
     */
    @Test
    void t7() {
//        templateMsgService.setIndustry();
//        templateMsgService.getIndustry();
        templateMsgService.sendTemplateMsg();
    }

    /**
     * 上传临时素材
     */
    @Test
    void t8() {
        // 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
        upload.upload("E:\\myPersonal\\jianyiingPractice\\Christmas Card 17.png", "image");
    }
}
