package com.yakumo.pubacc.service;

import com.yakumo.pubacc.util.PaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * Author cho1r
 * 2022/03/31 22:12
 */
@Component
public class Upload {
    // POST/FORM, https https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE
    private final String upload_url = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=%s&type=%s";

    @Autowired
    private PaUtil util;

    public void upload(String path, String type) {
        String accessToken = util.getAccessToken();
        String url = String.format(upload_url, accessToken, type);

        // 设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        // 设置请求体, 注意是LinkedMultiValueMap
        FileSystemResource fileSystemResource = new FileSystemResource(path);
        LinkedMultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", fileSystemResource);
        body.add("filename", fileSystemResource.getFilename());

        // 用HttpEntity封装整个请求报文
        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(body, headers);

        // 发送请求
        String resp = util.restTemplate.postForObject(url, entity, String.class);
        System.out.println(resp);
    }
}
