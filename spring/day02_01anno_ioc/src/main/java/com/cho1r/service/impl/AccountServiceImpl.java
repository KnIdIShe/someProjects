package com.cho1r.service.impl;

import com.cho1r.dao.IAccountDao;
import com.cho1r.service.IAccountService;
import com.cho1r.dao.impl.AccountDaoImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * Author cho1r
 * 2021/12/19 下午 06:29
 * 账户的业务层实现类
 * <bean id="accountService" class="com.cho1r.service.impl.AccountServiceImpl"
 * scope="" init-method="" destroy-method=""></bean>
 * <p>
 * 创建对象: 类似<bean></bean>
 * Component
 * Controller
 * Service
 * Repository
 * 数据注入:
 * AutoWired: 按照变量类型匹配, 若有多个, 再按照变量名匹配, 若都不匹配, 则报错
 */
// 默认id为类名首字母小写, 当只有value属性时, value= 可省略
@Service("accountService")
//@Scope("prototype")
public class AccountServiceImpl implements IAccountService {
    //    @Autowired
//    @Qualifier("accountDao2")
    // or
    @Resource(name = "accountDao1")
    private IAccountDao accountDao;

    @Value("tom")
    private String name;

    @PostConstruct
    public void init() {
        System.out.println("init.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy.");
    }

    @Override
    public void saveAccount() {
//        accountDao.saveAccount();
        System.out.println(name);
    }
}
