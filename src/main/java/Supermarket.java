import java.util.ArrayList;
import java.util.Scanner;

public static void main(String[]args){

};

public class Supermarket{
    private int count;
    private double allPrice;
    private ArrayList<Product> cart = new ArrayList<>();
    private String[] productList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getAllPrice() {
        double summ = 0.0;
        for (Product good : cart) {
            allPrice += good.getPrice();
        }
        return summ;
    }

    public void getCart() {
        System.out.println("Название (категори) - цена");
        for (Product good : cart) {
            System.out.println(good.getName()+" ("+good.getCategory()+") - "+good.getPrice());
        }
    }

    public void addProduct() {
        System.out.println("Введите имя, категорию и цену продукта");
        Scanner in = new Scanner(System.in);
        String[] res = in.next().split(",");
        Product newProduct = new Product(res[0], res[1], Double.parseDouble(res[2]));
        this.cart.add(newProduct);
        setCount(getCount()+1);
        System.out.println("Поздравляю! Вы добавили "+res[0]);
    }

    public void setProductList() {
        String[] products;
        System.out.println("Введите список покупок через Enter");
        
        this.productList = products;
    }
}

class Product {
    private String name;
    private String category;
    private double price;

    Product(String n, String c, double p) {
        setName(n);
        setCategory(c);
        setPrice(p);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
