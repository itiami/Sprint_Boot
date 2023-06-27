package wali.co.nboot.controllers.Product;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    List<Product> productList = new ArrayList<>();


    @GetMapping  // the url will be http://192.168.1.235:8080/api/product
    public List getAll() {
        productList.add(new Product("Logitech", "Webcam", "France", 1996));
        productList.add(new Product("Hp", "Keyboard", "Taiwan", 1996));
        productList.add(new Product("WD", "HDD", "France", 1996));
        //deleteById(2);
        return productList;
    }

   /* @GetMapping("del")
    public List deleteById(@RequestParam(name = "id") int x) {
        productList.removeIf(items -> items.getId() == x);
        System.out.println(productList);
        return productList;
    }*/
}
