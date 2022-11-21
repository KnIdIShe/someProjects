package com.cho1r;

import com.cho1r.domain.Book;
import com.cho1r.testcase.domain.BookCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

//@SpringBootTest({"test.prop=testValue11"})
//@SpringBootTest(args = {"--test.prop=testValue22"})
@SpringBootTest(properties = {"test.prop=testValue11"}, args = {"--test.prop=testValue22"})
class PropertiesAndArgsTest {

    @Value("${test.prop}")
    private String msg;

    @Autowired
    private BookCase bookCase;

    @Test
    void testProperties() {
        System.out.println(msg);
        System.out.println(bookCase);
    }

    @Test
    void testJdbcTemplate(@Autowired JdbcTemplate jdbcTemplate) {
//        String sql = "select * from tbl_book where id = 5";
        String sql = "select * from tbl_book";
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
//        System.out.println(maps);

        RowMapper<Book> rowMapper = new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setType(rs.getString("type"));
                book.setDescription(rs.getString("description"));
                return book;
            }
        };

        List<Book> list = jdbcTemplate.query(sql, rowMapper);
        System.out.println(list);

    }

    @Test
    void testJdbcTemplateSave(@Autowired JdbcTemplate jdbcTemplate) {
        String sql = "insert into tbl_book values (3, 'springboot1', 'springboot2', 'springboot3')";
        jdbcTemplate.update(sql);
    }

}
