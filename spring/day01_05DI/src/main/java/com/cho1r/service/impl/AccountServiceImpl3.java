package com.cho1r.service.impl;

import com.cho1r.service.IAccountService;

import java.util.*;


/**
 * Author cho1r
 * 2021/12/19 下午 06:29
 * 账户的业务层实现类
 */
public class AccountServiceImpl3 implements IAccountService {

    private String[] arr;
    private List<String> list;
    private Set<String> set;
    private Map<String, String> map;
    private Properties props;

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    @Override
    public void saveAccount() {
        System.out.println(Arrays.toString(arr));
        System.out.println(list);
        System.out.println(set);
        System.out.println(map);
        System.out.println(props);
    }

}
