package sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Service
public class SimpleServerWebSocketHandler extends TextWebSocketHandler {

    @Autowired
    private RandomTicker randomTicker;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("connected");
        randomTicker.addSession(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        System.out.println("recv: "+payload);
        if (!payload.isEmpty()) {
            randomTicker.broadcast("Server received : " + payload);
        }

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        System.out.println("closed");
        randomTicker.removeSession(session.getId());
    }
}
