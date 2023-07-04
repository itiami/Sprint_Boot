package co.wali.nboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Landing {
    @GetMapping("/")
    public String run(){
        return "Welcome Page.... File Location: src/main/java/wali/co/nboot/Landing.java";
    }
}
