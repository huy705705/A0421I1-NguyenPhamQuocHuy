package b7_abstract_class_interface.bai_tap.b2;

public class Test {


    public static void main(String[] args) {
//        Circle circle=new Circle(10,"red");
//        circle.resizeable();
//        Rectangle rectangle=new Rectangle();
//        rectangle.resizeable();
//        Square square=new Square(1.0);
//        square.resizeable();
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(10, "red");
        shapes[1] = new Rectangle();
        shapes[2] = new Square(1.0);
        for (Shape shape : shapes) {
            shape.howToColor();
            if(shape instanceof Rectangle){
                Rectangle rectangle=(Rectangle) shape;
                rectangle.howToColor();
            }
        }
//        System.out.println(shapes[0].getArea());
    }
}
