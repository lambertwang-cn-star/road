package com.banlv.road.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/2/9 14:39
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@PropertySource("classpath*:config/*.properties")
@ActiveProfiles("dev")
public class PropertiesGetTest {

    @Autowired
    ApplicationContext apx;

    @Autowired
    private Environment env;

    @Test
    public void getProperties() {
        ZookeeperConfig zookeeperConfig = (ZookeeperConfig) apx.getBean("zookeeperConfig");
        System.out.println(zookeeperConfig);
        Assert.assertEquals("192.168.196.135", zookeeperConfig.getHost());
    }

    @Test
    @Profile("dev")
    public void getEnvProperty() {
        Assert.assertEquals("192.168.196.135", env.getProperty("zoo.host"));
    }
}
