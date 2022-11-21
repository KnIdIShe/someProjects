package com;

import com.cho1r.Springboot04JunitApplication;
import com.cho1r.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

//@ContextConfiguration(classes = Springboot04JunitApplication.class)
@SpringBootTest(classes = Springboot04JunitApplication.class)
class Springboot04JunitApplicationTests {

    // 1. 注入需测试的对象
    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
        // 2. 执行需测试对象的方法
        bookDao.save();
        System.out.println("2");
    }

}
