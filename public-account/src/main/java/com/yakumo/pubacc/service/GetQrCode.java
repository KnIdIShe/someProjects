package com.yakumo.pubacc.service;

import cn.hutool.json.JSONObject;
import com.yakumo.pubacc.util.PaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author cho1r
 * 2022/04/01 10:19
 */
@Component
public class GetQrCode {
    @Autowired
    private PaUtil util;

    /**
     * 创建临时二维码 ticket
     *
     * @return
     */
    public String getQrCode() {
        String get_ticket_url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=";
        String get_qr_codeUrl = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";

        get_ticket_url += util.getAccessToken();
        // data: 生成字符串形式的二维码所需参数
        String data = "{\n" +
                "  \"expire_seconds\": 604800,\n" +
                "  \"action_name\": \"QR_STR_SCENE\",\n" +
                "  \"action_info\": {\n" +
                "    \"scene\": {\n" +
                "      \"scene_str\": \"test\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
        /**
         * {
         *   "ticket": "gQH47joAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL2taZ2Z3TVRtNzJXV1Brb3ZhYmJJAAIEZ23sUwMEmm3sUw==",
         *   "expire_seconds": 60,
         *   "url": "http://weixin.qq.com/q/kZgfwMTm72WWPkovabbI"
         * }
         * ticket	获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
         * expire_seconds	该二维码有效时间，以秒为单位。 最大不超过2592000（即30天）。
         * url	二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片
         */
        // 获取 ticket
        JSONObject resp = util.restTemplate.postForObject(get_ticket_url, data, JSONObject.class);
        System.out.println(resp);
        String ticket = resp.getStr("ticket");
        // 返回 get_qr_codeUrl
        return get_qr_codeUrl += ticket;
    }
}
