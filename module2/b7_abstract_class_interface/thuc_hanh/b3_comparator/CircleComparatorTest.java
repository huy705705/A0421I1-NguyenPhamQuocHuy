package b7_abstract_class_interface.thuc_hanh.b3_comparator;

import b6_inheritance.thuc_hanh.b1_shape.Circle;

import java.util.Arrays;
import java.util.Comparator;

public class CircleComparatorTest {
    public static void main(String[] args) {
        Circle[] circles=new Circle[3];
        circles[0]=new Circle(3.6);
        circles[1]=new Circle();
        circles[2]=new Circle("indigo",false,3.5);
        System.out.println("pre-sorted : ");
        for (Circle circle:circles){
            System.out.println(circle);
        }
        Comparator circleComparator=new CircleComparator();
        Arrays.sort(circles,circleComparator);
        Arrays.sort(circles,circleComparator);
        for(Circle circle:circles){
            System.out.println(circle);
        }
    }
}
