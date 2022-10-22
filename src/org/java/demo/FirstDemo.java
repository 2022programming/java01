package org.java.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fss
 * @create 2022-10-19 22:22
 */
public class FirstDemo {
    public static void main(String[] args) {
        int i = Integer.parseInt("1000");
        System.out.println("i = " + i);
        Integer integer = Integer.valueOf("1000");
        int intValue = integer.intValue();
        System.out.println("intValue = " + intValue);
        List list = new ArrayList();
        list.add(0,123);
    }
}
