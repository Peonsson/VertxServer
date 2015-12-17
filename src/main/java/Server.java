/**
 * Created by Peonsson on 17/12/15.
 */

import io.vertx.core.*;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
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

                if (request.method() == HttpMethod.GET) {
                    // Send back a response
                    HttpServerResponse response = request.response();
                    response.setStatusCode(200);
                    response.headers()
                            .add("Content-Length", String.valueOf(57))
                            .add("Content-Type", "text/html");

                    response.end("Vert.x is alive!");
                }
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