package com.cho1r.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

/**
 * Author cho1r
 * 16/2/2022 下午7:16
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// 开启虚拟 mvc 调用
@AutoConfigureMockMvc
public class WebTest {

    @Test
    public void testRandomPort(@Autowired MockMvc mockMvc) throws Exception {
        // 创建虚拟请求
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        // 执行虚拟请求
        mockMvc.perform(builder);
    }

    @Test
    public void testStatus(@Autowired MockMvc mockMvc) throws Exception {
        // 创建虚拟请求
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        // 执行虚拟请求
        ResultActions actions = mockMvc.perform(builder);

        // 设定预期值
        StatusResultMatchers status = MockMvcResultMatchers.status();
        ResultMatcher ok = status.isOk();

        // 添加预期值到本次调用过程中进行匹配
        actions.andExpect(ok);
    }

    @Test
    public void testBody(@Autowired MockMvc mockMvc) throws Exception {
        // 创建虚拟请求
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        // 执行虚拟请求
        ResultActions actions = mockMvc.perform(builder);

        // 设定预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher result = content.string("springboot");
        // 添加预期值到本次调用过程中进行匹配
        actions.andExpect(result);
    }

    @Test
    public void testJson(@Autowired MockMvc mockMvc) throws Exception {
        // 创建虚拟请求
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        // 执行虚拟请求
        ResultActions actions = mockMvc.perform(builder);

        // 设定预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher result = content.json("{\"id\":1,\"name\":\"springboot\",\"type\":\"springboot\",\"description\":\"springboot\"}");
        // 添加预期值到本次调用过程中进行匹配
        actions.andExpect(result);
    }

    @Test
    public void testContentType(@Autowired MockMvc mockMvc) throws Exception {
        // 创建虚拟请求
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        // 执行虚拟请求
        ResultActions actions = mockMvc.perform(builder);

        // 设定预期值
        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher contentType = header.string("Content-Type", "application/json");
        // 添加预期值到本次调用过程中进行匹配
        actions.andExpect(contentType);
    }
}
