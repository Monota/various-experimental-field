package tokyo.monota.study.websocket;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/chat")
public class ChatServerEndpoint {

    private static Set<Session> sessionSet = ConcurrentHashMap.newKeySet();

    @OnOpen
    public void onOpen(Session session) {
        sessionSet.add(session);
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        for (Session eachSession : sessionSet) {
            eachSession.getBasicRemote().sendText(message);
        }
    }

    @OnClose
    public void onClose(Session session) {
        sessionSet.remove(session);
    }
}
