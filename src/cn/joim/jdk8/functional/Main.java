package cn.joim.jdk8.functional;

import java.math.BigDecimal;

/**
 * 面向对象编程的函数式思想.
 * <p>
 * 在OldAccount中，
 * debit()和credit()在任何时候都可以及时地通过直接改变对象的状态来改变账户余额的值。
 * <p>
 * 这样的模型具有易变性，很难在并行设置下使用抽象，而且很难推理代码。
 * <p>
 * Balance balance在领域模型中是一个可变状态。"可变"，意味着该对象包含的这种状态可以被对象的多
 * 个客户端更新。进一步延伸到并发环境中，在决定状态值时就会遇到各种各样的矛盾类型，在任何时间任何
 * 位置。可变状态带来的问题远远多余它解决的问题。需要想办法干掉这些可变状态。
 */
public class Main {

    public static void main(String[] args) {


        changeableAccount();

        unchangeableAccount();
    }

    private static void changeableAccount() {
        var a = new OldAccount("a1", "Joim");

        a.creadit(BigDecimal.valueOf(100));

        a.debit(BigDecimal.valueOf(20));
    }

    private static void unchangeableAccount() {
        var a = new FunctionalAccount("a2", "John");
        var b = a.creadit(BigDecimal.valueOf(100));

        var c = a.debit(BigDecimal.valueOf(20));
    }
}
