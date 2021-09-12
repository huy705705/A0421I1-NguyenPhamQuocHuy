package b15_exception_debug.bai_tap;

import java.util.Scanner;

public class TestTriangle {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Kiem tra tam giac:");
        System.out.println("Nhap cac canh tam giac");
        boolean isTriangle=false;
            try {
                int side1 = scanner.nextInt();
                int side2 = scanner.nextInt();
                int side3 = scanner.nextInt();
                Triangle triangle = new Triangle();
                triangle.isCheckTriangle(side1, side2, side3);
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
            }
        
    }

}
