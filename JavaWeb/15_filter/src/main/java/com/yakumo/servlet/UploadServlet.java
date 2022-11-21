package com.yakumo.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Author cho1r
 * 20/1/2022 上午10:45
 */
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 判断是否是多段内容, 即文件上传
        if (ServletFileUpload.isMultipartContent(req)) {
            // 实体类
            ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());

            try {
                // 解析请求数据并遍历
                for (FileItem fileItem : servletFileUpload.parseRequest(req)) {
                    // 是否是普通项
                    if (fileItem.isFormField()) {
                        // 普通项
                        // UTF-8 解决中文乱码
                        // 表单的 name + value
                        System.out.println(fileItem.getFieldName() + ": " + fileItem.getString("UTF-8"));

                    } else {
                        // 文件项
                        // 表单的 name + 文件名
                        System.out.println(fileItem.getFieldName() + ": " + fileItem.getName());

                        // 写入文件至本地
                        fileItem.write(new File("D:\\" + fileItem.getName()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
