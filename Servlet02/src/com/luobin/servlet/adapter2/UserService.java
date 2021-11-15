package com.luobin.servlet.adapter2;

/**
 * @author Doraemon
 * @date 2021/11/15 5:24 下午
 * @version 1.0
 */

/**
 * 现在的 UserService 类，不需要直接实现 MyInterface 接口，不需要直接插入到 220 V电源上面，使用了一个巧妙的方法：
 *      直接继承了抽象类，将抽象类里面的方法实现了即可，使得代码看起来更加的简便
 */
public class UserService extends UserAdapter{
    @Override
    public void core() {

    }
}
