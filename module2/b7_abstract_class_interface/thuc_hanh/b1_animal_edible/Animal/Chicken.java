package b7_abstract_class_interface.thuc_hanh.b1_animal_edible.Animal;

public class Chicken extends Animal implements Edible {

    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck";
    }

    @Override
    public String howToEat() {
        return "Could be fried";
    }
}
