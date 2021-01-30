package com.kould.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

/**
 * from: https://blog.csdn.net/qq_40673786/article/details/94785935
 */
@Component
public class TransactionUtils {
    private final DataSourceTransactionManager dataSourceTransactionManager;

    public TransactionUtils(DataSourceTransactionManager dataSourceTransactionManager) {
        this.dataSourceTransactionManager = dataSourceTransactionManager;
    }

    public TransactionStatus begin() {
        System.out.println(">>>>事务开启了");
        TransactionStatus transaction = dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());
        return transaction;
    }

    public void commit(TransactionStatus transaction) {
        System.out.println(">>>>事务提交了");
        dataSourceTransactionManager.commit(transaction);
    }

    public void rollback(TransactionStatus transaction) {
        System.out.println(">>>>事务回滚了");
        dataSourceTransactionManager.rollback(transaction);
    }
}
