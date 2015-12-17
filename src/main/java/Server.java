/**
 * Created by Peonsson on 17/12/15.
 */

import io.vertx.core.*;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.net.NetServer;
import io.vertx.core.net.NetServerOptions;

public class Server extends AbstractVerticle {
    private HttpServer server = null;

    @Override
    public void start(Future<Void> future) throws Exception {
        // Create server
        server = vertx.createHttpServer();

        server.requestHandler(new Handler<HttpServerRequest>() {
            @Override
            public void handle(HttpServerRequest request) {
                System.out.println("incoming request!");
            }
        });

        server.listen(4000);
    }

    @Override
    public void stop(Future<Void> future) throws Exception {

    }
}