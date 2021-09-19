package b17_io_binary_file.bai_tap;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteProductFile {
    public static void main(String[] args) {
        List<Product> productList=new ArrayList<>();
        productList.add(new Product("P001","AAA","Car",1000,"123"));
        productList.add(new Product("P002","AAA","Car",1000,"123"));
        productList.add(new Product("P003","AAA","Car",1000,"123"));
        productList.add(new Product("P004","AAA","Car",1000,"123"));
        productList.add(new Product("P005","AAA","Car",1000,"123"));
        writeFile("C:\\Users\\ACER\\IdeaProjects\\java8huy\\src\\b17_\\bai_tap\\Product",productList);
        List<Product> productList1=new ArrayList<>();
        productList1=readFile("C:\\Users\\ACER\\IdeaProjects\\java8huy\\src\\b17_\\bai_tap\\Product");
        for(Product product:productList1){
            System.out.println(product.toString());
        }
    }
    public static void writeFile(String path,List<Product> productList){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(productList);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static List<Product> readFile(String path){
        List<Product> productList =new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
             productList =(List<Product>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
