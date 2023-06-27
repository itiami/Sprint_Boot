package wali.co.nboot.controllers.welcome;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to My first Spring Boot Project.." +
                "\n The API Url will be" +
                "\n http://domain:8080/welcome";
    }
}
