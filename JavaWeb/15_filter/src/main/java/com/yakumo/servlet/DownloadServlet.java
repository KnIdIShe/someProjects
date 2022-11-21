package com.yakumo.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Author cho1r
 * 20/1/2022 下午3:19
 */
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取要下载的文件名
//        String downloadFileName = "target.jsp";
        String downloadFileName = "华盛顿.jsp";

        // 读取下载的文件内容
        InputStream resourceAsStream = getServletContext().getResourceAsStream(downloadFileName);

        // 获取要下载的文件类型
        String mimeType = getServletContext().getMimeType(downloadFileName);
        // 回传前通过响应头告知客户端返回的数据类型
        resp.setContentType(mimeType);
//        resp.setContentType("text/jsp; charset=UTF-8");
        // 回传前通过响应头告知客户端返回的数据下载使用
//        resp.setHeader("Content-Disposition", "attachment; filename=" + downloadFileName);

        if (req.getHeader("User-Agent").contains("Firefox")) {
            resp.setHeader("Content-Disposition", "attachment; filename==?UTF-8?B?" + Base64.getEncoder().encodeToString(downloadFileName.getBytes(StandardCharsets.UTF_8)) + "?=");
        } else {
            resp.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(downloadFileName, "UTF-8"));
        }

        // 获取响应的输出流
        ServletOutputStream outputStream = resp.getOutputStream();

        IOUtils.copy(resourceAsStream, outputStream);
    }
}
