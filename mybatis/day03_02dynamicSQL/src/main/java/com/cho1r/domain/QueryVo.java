package com.cho1r.domain;

import java.util.List;

/**
 * Author cho1r
 * 2022/01/05 下午 07:23
 */
public class QueryVo {
    private User user;
    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
