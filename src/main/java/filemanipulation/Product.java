package filemanipulation;

public class Product {
    private int identifier;
    private String name;
    private int price;

    public Product(int identifier, String name, int price) {
        this.name = name;
        this.price = price;
        this.identifier = identifier;
    }

    public int getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return identifier + ";" + name + ";" + price;
    }
}
