package b12_java_colection.thuc_hanh.b1_;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestMap {
    public static void main(String[] args) {
        Map<String,Integer> hashMap=new HashMap<>();
        hashMap.put("Smith",30);
        hashMap.put("Anderson", 31);
        hashMap.put("Andersons", 32);
        hashMap.put("Andersonss", 33);
        System.out.println("Display entries in hashmap:");
        System.out.println(hashMap+"\n");
        Map<String,Integer> treeMap=new TreeMap<>();
        treeMap.put("Smiths",31);
        treeMap.put("Smithss",32);
        treeMap.put("Smithsss",33);
        treeMap.put("Smithssss",34);
        System.out.println("Dis play entries in ascending order of key:");
        System.out.println(treeMap);
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Anderson", 31);
        linkedHashMap.put("Lewis", 29);
        linkedHashMap.put("Cook", 29);
        System.out.println("\nThe age for " + "Lewis is " + linkedHashMap.get("Lewis"));
    }
}
