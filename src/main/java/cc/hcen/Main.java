package cc.hcen;


import cc.hcen.model.C;
import cc.hcen.model.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {

    public static Car car = new Car();
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
        return factory -> factory.setPort(C.port);
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @RequestMapping("")
    public String index() {
        return "/car/:[go,stop,back,left,right]\n/gui";
    }

    @RequestMapping("/gui")
    public String gui() {
        return "<script>\n" +
                "    (function () {\n" +
                "    " +
                "    window.location.href = \"http://hcen.cc:19000/ba90e737c3fe42189f96c9fb624bcb82/index.html\"\n" +
                "    " +
                "})()\n" +
                "</script>";
    }
}
