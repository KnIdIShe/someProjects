package com.cho1r.factory;

import com.cho1r.domain.Account;
import com.cho1r.service.IAccountService;
import com.cho1r.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author cho1r
 * 2021/12/26 下午 12:43
 * 用于创建service代理对象的工厂
 */
public class BeanFactory {

    private IAccountService accountService;
    private TransactionManager transactionManager;

    public final void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    /**
     * 获取service代理对象
     *
     * @return
     */
    public IAccountService getAccountService() {
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object retVal = null;
                try {
                    // 开启事务
                    transactionManager.startTransaction();
                    // 执行操作
                    retVal = method.invoke(accountService, args);
                    // 提交事务
                    transactionManager.commit();
                    // 返回结果
                    return retVal;
                } catch (Exception e) {
                    // 回滚事务
                    transactionManager.rollback();
                    throw e;
                } finally {
                    transactionManager.release();
                }
            }
        });
    }

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }
}
