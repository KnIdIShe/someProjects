package com.yakumo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Author cho1r
 * 18/1/2022 下午8:03
 */
public class SessionServlet extends BaseServlet {
    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        boolean isNew = session.isNew();
        String id = session.getId();

        resp.getWriter().write("session " + id + "<br>是否是新创建的 " + isNew);
    }

    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1", "value1");

        resp.getWriter().write("已经往 session 中添加了 key1");
    }

    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object attribute = req.getSession().getAttribute("key1");

        resp.getWriter().write("key1: " + attribute);
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // session 默认超时时长, 秒
        int interval = req.getSession().getMaxInactiveInterval();

        resp.getWriter().write("defaultLife: " + interval);
    }

    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // session 默认超时时长, 秒
        req.getSession().setMaxInactiveInterval(3);

        resp.getWriter().write("session life 3s set.");
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置 session 立即超时
        req.getSession().invalidate();

        resp.getWriter().write("session invalidated.");
    }
}
