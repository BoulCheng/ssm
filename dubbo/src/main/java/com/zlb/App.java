package com.zlb;

import com.alibaba.fastjson.JSON;
import com.zlb.api.TestService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    @Resource
    private static TestService testService2;

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        LiquibaseDto liquibaseDto = new LiquibaseDto();
        List<Liquibase> liquibaseList = testService2.list(liquibaseDto);
        System.out.println(JSON.toJSON(liquibaseList));
    }
}
