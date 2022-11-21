package com.yakumo.servlet;

import com.yakumo.servlet.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author cho1r
 * 18/1/2022 下午2:20
 */
public class CookieServlet extends BaseServlet {
    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建 cookie
        Cookie cookie = new Cookie("key3", "value3");
        // 通知客户端保存 cookie
        resp.addCookie(cookie);
        // 创建 cookie
        Cookie cookie2 = new Cookie("key4", "value4");
        // 通知客户端保存 cookie2
        resp.addCookie(cookie2);

        // 解决响应中文乱码问题
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().write("cookie 创建成功.");

    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();

        for (Cookie cookie : cookies) {
            resp.getWriter().write(cookie.getName() + ": " + cookie.getValue() + "<br>");
        }


        // 获取需要的 cookie
//        Cookie iwantCookie = null;
//
//        for (Cookie cookie : cookies) {
//            if ("key2".equals(cookie.getName())) {
//                iwantCookie = cookie;
//                break;
//            }
//        }

        Cookie iwantCookie = CookieUtils.getCookie("key1", cookies);

        if (iwantCookie != null) {
            resp.getWriter().write("找到了需要的 cookie: " + iwantCookie.getName());
        }

    }

    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Cookie cookie = new Cookie("key1", "newValue1");
//        resp.addCookie(cookie);
//        resp.getWriter().write("cookie " + cookie.getName() + " updated.");

        // 方式 2
        Cookie cookie = CookieUtils.getCookie("key2", req.getCookies());
        cookie.setValue("newValue2");
        resp.addCookie(cookie);

        resp.getWriter().write("cookie " + cookie.getName() + " updated.");
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("default", "default");
        resp.addCookie(cookie);
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = CookieUtils.getCookie("key3", req.getCookies());
        if (cookie != null) {
            cookie.setMaxAge(0);
            resp.addCookie(cookie);

            resp.getWriter().write(cookie.getName() + " deleted.");
        }
    }

    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("life3600", "life3600");
        cookie.setMaxAge(3600);
        resp.addCookie(cookie);

        resp.getWriter().write("3600s expires.");
    }

    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1", "path1");
        cookie.setPath(req.getContextPath() + "/abc");
        resp.addCookie(cookie);

        resp.getWriter().write("path cookie.");
    }
}
