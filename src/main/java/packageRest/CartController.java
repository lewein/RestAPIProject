package packageRest;

import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    @PostMapping(path = "/addProduct", consumes = "application/json", produces = "application/json")
    public String addProduct(@RequestBody Product newGood) {

    }
}
