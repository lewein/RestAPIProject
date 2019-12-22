package packageRest;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.ArrayList;
import java.util.Scanner;


@JsonAutoDetect

public class Cart{
    private double allPrice;
    private ArrayList<Product> cart = new ArrayList<>();
    private ArrayList<String> productList;


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
        Product newProduct = new Product(res[0].toLowerCase(), res[1], Double.parseDouble(res[2]));
        this.cart.add(newProduct);
        System.out.println("Поздравляю! Вы добавили "+res[0]);
    }

    public void setProductList() {
        System.out.println("Введите список покупок через запятую");
        Scanner in = new Scanner(System.in);
        String[] res = in.next().split(",");
        for (String str : res) {
            if (!checkInProductList(str)) {
                this.productList.add(str.toLowerCase());
            }
        }
    }

    public boolean checkInProductList(String good) {
        if (this.productList.contains(good.toLowerCase())) {
            System.out.println(good + " - этот продукт 2ды встречается в твоем списке! Я его не добавлю.");
            return true;
        } else {
            return false;
        }
    }

    public boolean checkInProductCart(String good) {

        return true;
    }
}


