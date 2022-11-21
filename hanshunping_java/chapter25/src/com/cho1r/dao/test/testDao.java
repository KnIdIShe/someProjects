package com.cho1r.dao.test;

import com.cho1r.dao.dao.ActorDao;
import com.cho1r.dao.dao.GoodsDao;
import com.cho1r.dao.domain.Goods;
import com.cho1r.jdbc.dataSource.Actor;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Author cho1r
 * 2021-11-24 024 12:56 下午
 */
public class testDao {

    @Test
    public void testActorDao() {
        ActorDao actorDao = new ActorDao();
        List<Actor> list = actorDao.queryMulti("select * from actor", Actor.class);
        list.forEach(System.out::println);

        Actor actor = actorDao.querySingle("select * from actor where id = ?", Actor.class, 2);
        System.out.println(actor);

        Object o = actorDao.queryScalar("select name from actor where id = ?", 1);
        System.out.println(o);

        int update = actorDao.update("insert into actor values (null, ?, ?, ?, ?)", "lily", "F", "2001-01-02", "125");
        System.out.println(update);
    }

    @Test
    public void testGoodsDao() {
        GoodsDao goodsDao = new GoodsDao();
//        int update = goodsDao.update("create table goods (id int, name varchar(10), price double)");
//        System.out.println(update);

//        int update = goodsDao.update("insert into goods values (?, ?, ?)", 1, "pear", 2.8);
//        System.out.println(update);

        for (Goods goods : goodsDao.queryMulti("select * from goods", Goods.class)) {
            System.out.println(goods);
        }

    }
}
