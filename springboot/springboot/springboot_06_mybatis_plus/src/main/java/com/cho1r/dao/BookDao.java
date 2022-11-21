package com.cho1r.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cho1r.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Author cho1r
 * 12/2/2022 下午2:11
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {
}