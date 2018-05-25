package net.golovach.eshop.entity.demo;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Created by BELSHINA on 14.02.2017.
 */
public class SpringDemoA {
    private int[] intArray;

    //@Autowired
    private Map<String, SpringDemoB> map;

    public SpringDemoA() {}

    public void setIntArray(int[] intArray) {
        this.intArray = intArray;
    }

    public void setMap(Map<String, SpringDemoB> map) {
        this.map = map;
    }
}
