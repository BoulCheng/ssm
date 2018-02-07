package com.zlb;

import com.alibaba.fastjson.JSON;
import com.zlb.api.TestService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestDubboTest {

    private ClassPathXmlApplicationContext context;

    private TestService testService2;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:spring/spring-config.xml");
        testService2 = (TestService)context.getBean("testService2");
    }
    @Test
    public void testDubbo() throws Exception {
        LiquibaseDto liquibaseDto = new LiquibaseDto();
        List<Liquibase> liquibaseList = testService2.list(liquibaseDto);
        System.out.println(JSON.toJSON(liquibaseList));
    }
}