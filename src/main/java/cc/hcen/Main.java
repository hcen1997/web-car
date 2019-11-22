package cc.hcen;


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
        return factory -> factory.setPort(8090);
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }

    @RequestMapping("")
    public String index(){
        return "/car/go;/car/stop;/car/back;\n/gui";
    }
    @RequestMapping("/gui")
    public String gui(){
        //language=HTML
        String html = "<button onclick=\"fetch('/car/go')\">go</button>\n" +
                "<button onclick=\"fetch('/car/stop')\">stop</button>\n" +
                "<button onclick=\"fetch('/car/back')\">back</button>\n" +
                "<img id=\"last\" src=\"http://192.168.0.110:8091/jpg/1574085661.jpg\" />\n" +
                "<script>\n" +
                "    function run() {\n" +
                "        let u = 'http://'+ window.location.hostname + ':8091/jpg'\n" +
                "        fetch(u)\n" +
                "            .then(function(response) {\n" +
                "                return response.text();\n" +
                "            }).then(function(data) {\n" +
                "            let div = document.createElement('div')\n" +
                "            div.innerHTML = data\n" +
                "            let list = div.getElementsByTagName('li')\n" +
                "            let last = list.item(list.length-1)\n" +
                "            let lastName = last.textContent\n" +
                "            let img = document.getElementById('last')\n" +
                "            img.src = u + '/'+ lastName\n" +
                "        });   \n" +
                "        \n" +
                "    }\n" +
                "    setInterval(run,1000)\n" +
                "</script>";
        return html;
    }
}
