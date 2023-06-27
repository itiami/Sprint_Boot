package wali.co.nboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Landing {
    @GetMapping("/")
    public String run(){
        return "Welcome";
    }
}
