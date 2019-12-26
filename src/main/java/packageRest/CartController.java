package packageRest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

@RestController
public class CartController {
    private Cart cart = new Cart();

    @PostMapping(path = "/addProduct", consumes = "application/json", produces = "application/json")
    public String addProduct(@RequestBody Product newGood) {
        FileLoad file = new FileLoad();
        ObjectMapper mapper = new ObjectMapper();
        StringWriter writer = new StringWriter();
        try {
            mapper.writeValue(writer, newGood);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = writer.toString();
        try {
            file.writeFile(newGood.getName(), result);
            cart.addProduct(newGood);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "{\"status\":\"ok\"}";
    }

    @RequestMapping("/cartPrice")
    public Object cartPrice() {
        Double price = cart.getAllPrice();
        return "{\"status\":\"ok\",\"CartPrice\":\"" + price + "\"}";
    }


    @RequestMapping(path = "/setProductList", consumes = "application/json", produces = "application/json")
    public String setProductList(@RequestParam (value="list", required=false, defaultValue="") String list) {

        FileLoad file = new FileLoad();
        ObjectMapper mapper = new ObjectMapper();
        StringWriter writer = new StringWriter();
        try {
            mapper.writeValue(writer, list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        cart.setProductList(list);
        return "{\"status\":\"ok\"}";
    }

    @RequestMapping(path = "/myCart")
    public ArrayList<Product> getCart() {
        return (this.cart.getCart());
    }

}
