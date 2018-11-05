package com.topiea.utils;

/**
 * @Author: kent long
 * @Date: 2018/11/5 下午 01:05
 * ++a ,与a++ 区别
 */
public class PlusPlusTest {
    private static  int a = 0;
    public static void main(String[] args) {
        System.out.println("a="+a);
        a++;
        System.out.println("加加a后"+a);

        System.out.println(a++);
    }
}
