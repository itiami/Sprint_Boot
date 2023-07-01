package wali.co.nboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class Landing {
    @GetMapping("/")
    public String run(){
        return "Welcome Page.... File Location: src/main/java/wali/co/nboot/Landing.java";
    }
}
