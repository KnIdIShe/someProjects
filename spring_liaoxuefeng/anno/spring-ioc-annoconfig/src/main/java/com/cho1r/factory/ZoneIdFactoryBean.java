package com.cho1r.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.ZoneId;

/**
 * Author cho1r
 * 2021/12/23 下午 02:44
 */
@Component
public class ZoneIdFactoryBean implements FactoryBean<ZoneId> {
    private String zone = "Z";

    @Override
    public ZoneId getObject() throws Exception {
        return ZoneId.of(zone);
    }

    @Override
    public Class<?> getObjectType() {
        return ZoneId.class;
    }
}
