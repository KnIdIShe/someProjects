package com.yakumo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yakumo.domain.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * Author cho1r
 * 12/2/2022 下午2:11
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {
}
