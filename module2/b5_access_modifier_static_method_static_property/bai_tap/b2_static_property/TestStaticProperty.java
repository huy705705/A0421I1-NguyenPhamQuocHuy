package b5_access_modifier_static_method_static_property.bai_tap.b2_static_property;

public class TestStaticProperty {
    public static void main(String[] args) {
        Car car1=new Car("mazda 3","Skyactiv 3");
        System.out.println(Car.numberOfCar);
        Car car2=new Car("mazda 6","Skyactiv 6");
        System.out.println(Car.numberOfCar);

    }
}
