package com.cho1r.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Author cho1r
 * 2021/12/23 下午 03:23
 */
@Component
public class LogPrint {

    @Value("classpath:/log.txt")
    private Resource resource;

    public void logPrint() throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
            String row;
            while ((row = reader.readLine()) != null) {
                System.out.println(row);
            }
        }
    }
}
