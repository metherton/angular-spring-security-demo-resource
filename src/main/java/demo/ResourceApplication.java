package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
@RestController
public class ResourceApplication {

    @RequestMapping("/resource")
    public Map<String,Object> home() {
        Map<String,Object> model = new HashMap<String,Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World");
        return model;
    }

    @RequestMapping("/route")
    public Map<String,Object> route() {
        Map<String,Object> model = new HashMap<String,Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "this is the route");
        return model;
    }

    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class, args);
    }

    @Bean
    HeaderHttpSessionStrategy sessionStrategy() {
        return new HeaderHttpSessionStrategy();
    }

}
