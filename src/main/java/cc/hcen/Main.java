package cc.hcen;


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
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
        return factory -> factory.setPort(80);
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }

    @RequestMapping("")
    public String index(){
        return "/car/go;/car/stop;/car/back;\n/set/LFF/25;/set/RBB/30";
    }
}
