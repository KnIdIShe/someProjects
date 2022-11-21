package com.cho1r.dao;

import com.cho1r.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Author cho1r
 * 12/2/2022 下午2:11
 */
@Mapper
public interface BookDao {
    @Select("select * from tbl_book where id = #{id}")
    Book getById(long id);
}
