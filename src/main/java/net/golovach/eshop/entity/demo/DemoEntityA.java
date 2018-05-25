package net.golovach.eshop.entity.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by BELSHINA on 08.02.2017.
 */
public class DemoEntityA {
    private String str;
    private String[] array;
    private List<Integer> list;
    private Map<String, String> map;
    private DemoEntityB mockEntityB;

    public DemoEntityA() {
        this.str = "str";
        this.array = new String[] {"AAA", "BBB", "CCC"};
        this.list = Arrays.asList(123, 456, 789);
        this.map = new HashMap<String, String>()
        {
            {
                put("key-0", "value-0");
            }
        };
        this.mockEntityB = new DemoEntityB();
    }

    public String getStr() {
        return str;
    }

    public String[] getArray() {
        return array;
    }

    public List<Integer> getList() {
        return list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public DemoEntityB getMockEntityB() {
        return mockEntityB;
    }
}
