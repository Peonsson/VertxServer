/**
 * Created by Peonsson on 17/12/15.
 */

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;

public class Server extends AbstractVerticle {
    private HttpServer server = null;
    EventBus eb = null;

    @Override
    public void start(Future<Void> future) throws Exception {
        // Create server
        server = vertx.createHttpServer();

        // Create eventbus
        eb = vertx.eventBus();

        server.requestHandler(request -> {
            System.out.println("incoming request!");

            if (request.method() == HttpMethod.GET) {
                // Send back a response
                HttpServerResponse response = request.response();
                // This should probably be changed
                response.setChunked(true);
                response.write("hello world!");
                response.end();
            }
        });

        server.listen(4000, res -> {
            if (res.succeeded()) {
                System.out.println("Server is now listening!");
            } else {
                System.out.println("Failed to bind!");
            }
        });
    }

    @Override
    public void stop(Future<Void> future) throws Exception {

    }
}