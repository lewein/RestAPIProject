package packageRest;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.ArrayList;
import java.util.Scanner;


@JsonAutoDetect

public class Cart{
    private double allPrice;
    private ArrayList<Product> cart = new ArrayList<>();
    private ArrayList<String> productList = new ArrayList<>();


    public double getAllPrice() {
        double allPrice = 0.0;
        for (Product good : cart) {
            allPrice += good.getPrice();
        }
        return allPrice;
    }

    public void setAllPrice(double newPrice) {
        this.allPrice = getAllPrice()+newPrice;
    }

    public ArrayList<Product> getCart() {
        return this.cart;
    }

    public void addProduct(Product newGood) {
        this.cart.add(newGood);
        setAllPrice(newGood.getPrice());
        System.out.println("Поздравляю! Вы добавили ");
    }

    public void setProductList(String list) {
        for (String str : list.split(",")) {
            this.productList.add(str.toLowerCase());
        }
    }

    public Object checkInProductList(String good) {
        if (this.productList.size() == 0) {
            return ("В твоем списке пусто, не могу проверить.");
        }
        if (this.productList.contains(good.toLowerCase())) {
            return ("Да, в твоем списке есть такой продукт.");
        } else {
            return ("По твоему запросу ничего не найдено.");
        }
    }

    public boolean checkInProductCart(String good) {

        return true;
    }
}


