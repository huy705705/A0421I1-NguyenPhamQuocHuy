package b12_java_colection.demo;

import b10.bai_tap.b1_.Person;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DemoMap {
    public static void main(String[] args) {
        Map<String , Person> map= new HashMap<>();
        map.put("P001",new Person("P001","Khanh",new Date(7,5,2000)));
        map.put("P002",new Person("P002","Hung",new Date(7,5,2000)));
        map.put("P003",new Person("P003","Nam",new Date(7,5,2000)));
        map.put("P004",new Person("P004","Bao",new Date(7,5,2000)));
        Set<Map.Entry<String,Person>> personEntries=map.entrySet();
        for(Map.Entry<String,Person> entry:personEntries){
            System.out.printf("Key: %s,Data: %s \n",entry.getKey(),entry.getValue().toString());
        }

    }
}
