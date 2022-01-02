package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProductFileManager {
    List<Product> products = new ArrayList<>();

    public void readProductsFromFile(Path path) {
        List<String> tempProducts;
        try {
            tempProducts = Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
        putDataToProducts(tempProducts);
    }

    private void putDataToProducts(List<String> tempProducts) {
        for (String s : tempProducts) {
            String[] str = s.split(";");
            Product product = new Product(Integer.parseInt(str[0]), str[1], Integer.parseInt(str[2]));
            products.add(product);
        }
    }

    public void writePriceOverToFile(Path path, int price) {
        List<String> collectedProducts = collectTheProductsWithHigherPriceThanTheParam(price);
        try {
            Files.write(path, collectedProducts);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't write file!", ioe);
        }
    }

    private List<String> collectTheProductsWithHigherPriceThanTheParam(int price) {
        List<String> collect = new ArrayList<>();
        for (Product p : products) {
            if (p.getPrice() > price) {
                collect.add(p.toString());
            }
        }
        return collect;
    }

    public List<Product> getProducts() {
        return products;
    }
}
