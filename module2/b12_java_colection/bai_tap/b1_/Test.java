package b12_java_colection.bai_tap.b1_;

import demo._1.ManagerOfficer;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ManagerProduct managerProduct=new ManagerProduct();
        managerProduct.add( new Product("1","bao","12"));
        managerProduct.add( new Product("4","thuy","13"));
        managerProduct.add( new Product("3","anh","10"));
//        System.out.println(managerProduct.remove());
//        managerProduct.lastIndexOf((List) managerProduct);4
        managerProduct.edit("4","hang","123");
        managerProduct.sortByPrice();
        managerProduct.sortByName();
        managerProduct.showListInforProduct();
        System.out.println(managerProduct.searchByName("bao"));
        
    }
}
