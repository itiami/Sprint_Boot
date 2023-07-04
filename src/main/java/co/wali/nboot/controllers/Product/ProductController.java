package co.wali.nboot.controllers.Product;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    List<Product> productList = new ArrayList<>();

    public ProductController() {
        productList.add(new Product(1,"Logitech", "Webcam", "France", 1996));
        productList.add(new Product(2,"Hp", "Keyboard", "Taiwan", 1996));
        productList.add(new Product(3,"WD", "HDD", "France", 1996));
        //deleteById(2);
    }

    @GetMapping  // the url will be http://192.168.1.235:8080/api/product
    public List getAll(){
        return productList;
    }

    // http://192.168.1.235:8080/api/product/del?id=2
    @GetMapping("del")
    public List deleteById(@RequestParam(name = "id") int x) {
        productList.removeIf(items -> items.getId() == x);
        System.out.println(productList);
        return productList;
    }
}
