package com.cho1r;

import com.cho1r.config.MsgConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
 * Author cho1r
 * 16/2/2022 下午6:52
 */
@SpringBootTest
@Import(MsgConfig.class)
public class ConfigurationTest {

    @Autowired
    private String msg;
}
