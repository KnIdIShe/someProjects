package com.yakumo.controller;

import com.yakumo.domain.Account;
import com.yakumo.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Author cho1r
 * 12/1/2022 下午9:05
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        System.out.println("SpringMVC findAll.");
        // 调用 service 的方法
        List<Account> list = accountService.findAll();
        model.addAttribute("list", list);
        return "list";
    }

    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("SpringMVC save.");
        // 调用 service 的方法
        accountService.saveAccount(account);
        // 重定向
        response.sendRedirect(request.getContextPath() + "/account/findAll");

//        return "redirect:account/findAll";
    }
}
