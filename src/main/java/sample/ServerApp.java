package sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ServerApp {

    public static ConfigurableApplicationContext app = null;
    
    public static void main(String[] args) {
        app=SpringApplication.run(ServerApp.class, args);
    }
    
    public static void exit(){
        app.close();
    }
    
}