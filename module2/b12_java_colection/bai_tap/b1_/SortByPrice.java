package b12_java_colection.bai_tap.b1_;

import java.util.Comparator;

public class SortByPrice implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getPrice().compareTo(o2.getPrice());
    }
}
