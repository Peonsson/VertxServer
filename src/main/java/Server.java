/**
 * Created by Peonsson on 17/12/15.
 */

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.http.HttpServer;

public class Server extends AbstractVerticle {
    private EventBus eb = null;

    @Override
    public void start(Future<Void> future) throws Exception {

        eb = getVertx().eventBus();
        HttpServer server = vertx.createHttpServer();

        server.websocketHandler(websocket -> {
            System.out.println("Connected!");
        });

        server.listen(4000);

//                server.websocketHandler(ws -> ws.handler(ws::writeBinaryMessage))
//                .requestHandler(req -> req
//                .response().write("HELLO WORLD!"))
//                .listen(4000);
    }
}
