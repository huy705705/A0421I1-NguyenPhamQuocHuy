package b12_java_colection.bai_tap.b1_;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ManagerProduct {
    private List<Product> products;

    public ManagerProduct() {
        this.products = new ArrayList<>();
    }
    public void add(Product product){
        this.products.add(product);
    }
    public boolean remove(String id){
        Product product=this.products.stream()
                .filter(product1 -> product1.getId().equals(id))
                .findFirst().orElse(null);
        if(product==null){
            return false;
        }
        this.products.remove(product);
        return true;
    }

    public void showListInforProduct(){
        this.products.forEach(o-> System.out.println(o.toString()));
    }
    public boolean edit(String id, String name, String price){
        Product product=this.products.stream()
                .filter(product1 -> product1.getId().equals(id))
                .findFirst().orElse(null);
        if(product==null){
            return false;
        }else {
            product.setName(name);
            product.setPrice(price);
            return true;
        }

    }
    public void sortByPrice(){
        Collections.sort(products,new SortByPrice());
    }
    public void sortByName(){
        Collections.sort(products);
    }
    public List<Product> searchByName(String name){
        return this.products.stream()
                .filter(product -> product.getName().equals(name))
                .collect(Collectors.toList());
    }
}
