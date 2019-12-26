package packageRest;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class CartControllerTest {

    private CartController cartController = new CartController();

    Product createTestProductOne() {
        Product testProduct = new Product("salami", "smoked meat", 4.99);
        return testProduct;
    }

    Product createTestProductTwo() {
        Product testProduct = new Product("champignons", "mushrooms", 9.46);
        return testProduct;
    }

    void deleteProduct(Product product) {
        File file = new File(product.getName());
        assertEquals(true, file.delete());
    }

    @org.junit.jupiter.api.Test
    void addProduct() {
        Product product = this.createTestProductOne();
        String res = this.cartController.addProduct(product);
        assertEquals(res, "{\"status\":\"ok\"}");
        this.deleteProduct(product);
    }

    @org.junit.jupiter.api.Test
    void cartPrice() {
        Product product1 = this.createTestProductOne();
        this.cartController.addProduct(product1);
        Product product2 = this.createTestProductTwo();
        this.cartController.addProduct(product2);
        Double price = 0.0;
        price += product1.getPrice();
        price += product2.getPrice();
        String res = this.cartController.cartPrice();
        assertEquals(res, "{\"status\":\"ok\",\"CartPrice\":\"" + price + "\"}");
        this.deleteProduct(product1);
        this.deleteProduct(product2);
    }

    @org.junit.jupiter.api.Test
    void setProductList() {
        String res = this.cartController.setProductList("milk,solt,mushrooms");
        assertEquals(res, "{\"status\":\"ok\"}");
    }

}