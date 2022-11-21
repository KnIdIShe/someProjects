package com.yakumo.servlet;

import com.domain.Person;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author cho1r
 * 21/1/2022 上午10:07
 */
public class AjaxServlet extends BaseServlet {

    protected void javaScriptAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Ajax request received.");

        Person person = new Person(1, "tom");
        String personJsonString = new Gson().toJson(person);

        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().write(personJsonString);
    }

    protected void jQueryAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("jQuery Ajax request received.");

        Person person = new Person(1, "tom");
        String personJsonString = new Gson().toJson(person);

        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().write(personJsonString);
    }

    protected void jQueryGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("jQueryGet Ajax request received.");

        Person person = new Person(1, "tom");
        String personJsonString = new Gson().toJson(person);

        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().write(personJsonString);
    }

    protected void jQueryPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("jQueryPost Ajax request received.");

        Person person = new Person(1, "tom");
        String personJsonString = new Gson().toJson(person);

        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().write(personJsonString);
    }

    protected void jQueryGetJSON(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("jQueryGetJSON Ajax request received.");

        Person person = new Person(1, "tom");
        String personJsonString = new Gson().toJson(person);

        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().write(personJsonString);
    }

    protected void jQuerySerialize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("jQuerySerialize Ajax request received.");
        System.out.println("username: " + request.getParameter("username"));
        System.out.println("password: " + request.getParameter("password"));

        Person person = new Person(1, "tom");
        String personJsonString = new Gson().toJson(person);

        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().write(personJsonString);
    }
}
