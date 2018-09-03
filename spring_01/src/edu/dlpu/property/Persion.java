package edu.dlpu.property;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Persion {
    private String pname;

    private String[] arrs;
    private List<String> list;
    private Map<String,String> map;

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    private Properties properties;

    public void setArrs(String[] arrs) {
        this.arrs = arrs;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }


    public void test1(){
        System.out.println("persion......"+pname);
        System.out.println("arrs:"+arrs);
        System.out.println("list"+list);
        System.out.println("map"+map);
        System.out.println("properties"+properties);
    }
}
