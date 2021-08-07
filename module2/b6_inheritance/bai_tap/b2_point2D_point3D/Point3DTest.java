package b6_inheritance.bai_tap.b2_point2D_point3D;

import java.util.Arrays;

public class Point3DTest {
    public static void main(String[] args) {
        Point3D point3D=new Point3D(3.1f,3.2f,3.3f);
        System.out.println(point3D.toString());
        System.out.println(Arrays.toString(point3D.getXYZ()));

    }
}
