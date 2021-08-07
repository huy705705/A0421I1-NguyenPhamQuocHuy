package b6_inheritance.bai_tap.b3_point_movable_point;

public class MovablePointTest {
    public static void main(String[] args) {
        MovablePoint movablePoint=new MovablePoint(1.0f,1.0f,3.0f,3.0f);
        System.out.println(movablePoint.toString());
        System.out.println(movablePoint.move());

    }
}
