package b17_io_binary_file.bai_tap;

import java.io.Serializable;

public class Product implements Serializable {
    public static final long serialVersionUID=2L;
    public String id;
    public String name;
    private String producer;
    private int price;
    private String note;

    public Product(String id, String name, String producer, int price, String note) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.price = price;
        this.note = note;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
