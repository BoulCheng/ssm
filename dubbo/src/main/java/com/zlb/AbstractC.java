package com.zlb;

/**
 * Created by Lubiao Zheng
 * Created time 2018/1/30 15:01
 * Description
 *
 * 普通类实现接口必须实现接口所有的方法  可能会造成实现多余的方法 代码冗余
 * 抽象类实现接口可以只实现该接口部分的方法  或者不实现任何方法
 * 当其他类继承抽象类时 则一定要实现该接口中有但抽象类中没有实现的方法
 */
public abstract class AbstractC implements InterB {

    void doC() {
        System.out.println("c");
    }

    @Override
    public void doA() {

    }

}
