package com.yakumo.pubacc.controller;

import com.yakumo.pubacc.service.GetQrCode;
import com.yakumo.pubacc.service.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * Author cho1r
 * 2022/03/29 20:03
 */
@RestController
public class IndexController {

    @Autowired
    private WxService service;
    @Autowired
    private GetQrCode getQrCode;

    @GetMapping("/")
    public String authCheck(@RequestParam Map<String, String> params) {
        /**
         * signature	微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
         * timestamp	时间戳
         * nonce	随机数
         * echostr	随机字符串
         */
//        System.out.println("wx platform send get.");
//        params.forEach((k, v) -> {
//            System.out.println(k + "\t" + v);
//        });

        if (service.authCheck(params)) {
            return params.get("echostr");
        }

        return "hello, world!";
    }

    //    public void textMsg(@RequestBody TextMsg textMsg) {
//        System.out.println(textMsg);
//    }
    @PostMapping(value = "/")
    public String sendMsg(HttpServletRequest request) {
        Map<String, String> recvmsg = null;

        try {
            recvmsg = service.parseRecvMsg(request.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 回复消息
        assert recvmsg != null;
        return service.getReplyXml(recvmsg);
    }

    @GetMapping("/qrcode")
    public String getQrCode() {
        String imgStr = "<img src=\"%s\">";
        imgStr = String.format(imgStr, getQrCode.getQrCode());
        return imgStr;
    }

    @GetMapping("/userinfo")
    public String getUserInfo(@RequestParam String code) {
        return service.getUserInfo(code);
    }
}
