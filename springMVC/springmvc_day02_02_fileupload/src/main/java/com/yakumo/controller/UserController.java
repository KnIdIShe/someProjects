package com.yakumo.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.yakumo.domain.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Author cho1r
 * 2022/01/12 上午 10:36
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 跨服务器 文件上传
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileUpload03")
    public String fileUpload03(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("跨服务器 file upload...");

        // 上传的位置
        String path = "http://localhost:8090/springmvc_day02_02_fileupload_fileServer_war_exploded/uploads/";

        String filename = upload.getOriginalFilename();
        // 文件名设置为唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;

        // 创建客户端对象
        Client client = Client.create();

        // 连接图片服务器
        WebResource webResource = client.resource(path + filename);

        // 完成文件上传
        webResource.put(upload.getBytes());
        return "success";
    }

    /**
     * SpringMVC 文件上传
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileUpload02")
    public String fileUpload02(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("SpringMVC file upload...");

        // 上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // 判断路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            // 不存在则创建
            file.mkdirs();
        }

        // 上传文件项

        String filename = upload.getOriginalFilename();
        // 文件名设置为唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        // 完成文件上传
        upload.transferTo(new File(path, filename));

        return "success";
    }


    /**
     * 传统文件上传
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileUpload01")
    public String fileUpload01(HttpServletRequest request) throws Exception {
        System.out.println("file upload...");

        // 上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // 判断路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            // 不存在则创建
            file.mkdirs();
        }

        // 解析 request 对象, 获取上传文件项
        ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
        List<FileItem> fileItems = upload.parseRequest(request);

        for (FileItem fileItem : fileItems) {
            if (fileItem.isFormField()) {
                // 普通表单项
            } else {
                // 上传文件项

                String filename = fileItem.getName();
                // 文件名设置为唯一值
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = uuid + "_" + filename;
                // 完成文件上传
                fileItem.write(new File(path, filename));
                // 删除临时文件
                fileItem.delete();
            }
        }

        return "success";
    }

}
