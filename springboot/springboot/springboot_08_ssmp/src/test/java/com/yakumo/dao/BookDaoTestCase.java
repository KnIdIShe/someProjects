package com.yakumo.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yakumo.domain.Book;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Author cho1r
 * 12/2/2022 下午8:05
 */
@SpringBootTest
public class BookDaoTestCase {
    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById() {
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setType("c");
        book.setName("c");
        book.setDescription("c从入门到放弃");
        bookDao.insert(book);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(4);
        book.setType("ccccccccc");
        book.setName("c");
        book.setDescription("c从入门到放弃");
        bookDao.updateById(book);
    }

    @Test
    void testDelete() {
        bookDao.deleteById(4);
    }

    @Test
    void testGetAll() {
//        bookDao.selectList(null).forEach(System.out::println);
        bookDao.selectList(null);
    }

    @Test
    void testGetPage() {
        IPage<Book> page = new Page<>(2, 3);
        bookDao.selectPage(page, null);

        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }

    @Test
    void testGetBy() {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "入门");
        bookDao.selectList(queryWrapper);
    }

    @Test
    void testGetBy2() {
        String desc = null;
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
//        lqw.like(desc != null, Book::getDescription, "入门");
        lqw.like(Strings.isNotEmpty(desc), Book::getDescription, "入门");
        bookDao.selectList(lqw);
    }
}
