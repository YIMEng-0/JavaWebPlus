package com.luobin.servlet.adapter2;

/**
 * @author Doraemon
 * @date 2021/11/15 5:18 下午
 * @version 1.0
 */
// 抽象方法只能出现在抽象类中，所以类必须是抽象类
// UserService 的适配器
public abstract class UserAdapter implements MyInterface {
    @Override
    public void m1() {

    }

    @Override
    public void m2() {

    }

    @Override
    public void m3() {

    }

    @Override
    public void m4() {

    }

    @Override
    public void m5() {

    }

    @Override
    abstract public void core();
}
