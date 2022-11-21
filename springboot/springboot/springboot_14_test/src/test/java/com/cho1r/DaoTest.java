package com.cho1r;

import com.cho1r.dao.BookDao;
import com.cho1r.domain.Book;
import com.cho1r.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author cho1r
 * 17/2/2022 下午3:53
 */
@SpringBootTest
@Transactional
@Rollback(value = false)
public class DaoTest {
    @Autowired
    private BookService bookService;

    @Autowired
    private BookDao bookDao;

    @Test
    void testSave() {
        Book book = new Book();
        book.setName("springboot");
        book.setType("springboot");
        book.setDescription("springboot");

//        bookService.save(book);

    }

    @Test
    void test() {
        bookDao.selectById(3);
    }
}
