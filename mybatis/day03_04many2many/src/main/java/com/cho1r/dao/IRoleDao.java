package com.cho1r.dao;

import com.cho1r.domain.Role;

import java.util.List;

/**
 * Author cho1r
 * 2022/01/08 上午 10:26
 */
public interface IRoleDao {

    /**
     * 查询所有角色
     *
     * @return
     */
    List<Role> findAll();
}
