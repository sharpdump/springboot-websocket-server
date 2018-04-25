package sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class ApplicationConfigurer implements WebSocketConfigurer {

    @Autowired
    SimpleServerWebSocketHandler simpleServerWebSocketHandler;

    @Override public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(simpleServerWebSocketHandler, "/echo").setAllowedOrigins("*");
    }
    
    @Bean
    public EmbeddedServletContainerCustomizer customConfig(){
        return (container->{
            container.setPort(8881);
        });
    }
}
