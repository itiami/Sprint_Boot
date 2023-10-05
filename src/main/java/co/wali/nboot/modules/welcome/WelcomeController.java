package co.wali.nboot.modules.welcome;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

@RestController
public class WelcomeController {

    public String readHtmlFile() throws Exception {
        String dir = Paths.get("")
                .toAbsolutePath()
                .toString();
        System.out.println("using Paths.get(): " +dir); // using Paths.get(): D:\JavaApp\SpringBoot\nboot

        String fileDir = new File("").getAbsolutePath();
        System.out.println("using new File(): " + fileDir); // using new File(): D:\JavaApp\SpringBoot\nboot

        String userDirectory = System.getProperty("user.dir");
        System.out.println("using System.getProperty(): " + userDirectory); // using System.getProperty(): D:\JavaApp\SpringBoot\nboot

        File inputFile = new File("./src/main/java/co/wali/nboot/controllers/welcome/welcome.jsp");
            StringBuilder stringBuilder = new StringBuilder();
            Scanner reader = new Scanner(inputFile);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                stringBuilder.append(data);
            }
            reader.close();
            return stringBuilder.toString();
    }

    public String getFileFromResource() throws Exception {
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        JSONTokener tokener;

        InputStream url = getClass().getClassLoader().getResourceAsStream("static/sample.json");
        assert url != null;
        tokener = new JSONTokener(url);
        JSONObject jsonObject = new JSONObject(tokener);
        return jsonObject.toString(4);
    }

    private String readFileByJsoup() throws Exception{
        Document htmlDoc = Jsoup.parse(new File("D:\\JavaApp\\SpringBoot\\nboot\\src\\main\\java\\co\\wali\\nboot\\controllers\\welcome\\welcome.jsp"));
        return htmlDoc.outerHtml();
    }

    @GetMapping("/welcome")
    public String welcome() throws Exception {
        //return "Welcome to My first Spring Boot Project.."; // Output - a simple text on browser
        //return getFileFromResource(); // or Output a json file
        //return readFileByJsoup();
        return readHtmlFile();
    }
}
