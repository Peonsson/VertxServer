/**
 * Created by Peonsson on 17/12/15.
 */

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServer;

public class Server extends AbstractVerticle {
    private HttpServer server = null;

    @Override
    public void start(Future<Void> future) throws Exception {
        // Create server
        server = vertx.createHttpServer();

        vertx.createHttpServer().requestHandler(request -> {
            request.response().end("Hello world");
        }).listen(4000);

//        server.requestHandler(new Handler<HttpServerRequest>() {
//            @Override
//            public void handle(HttpServerRequest request) {
//                System.out.println("incoming request!");
//
//
//
//                if (request.method() == HttpMethod.GET) {
//                    // Send back a response
//                    HttpServerResponse response = request.response();
//
//                    response.setStatusCode(200);
//                    response.headers()
//                            .add("Content-Length", String.valueOf(57))
//                            .add("Content-Type", "text/html");
//
//                    response.write("<html><body>Vert.x is alive!</body></html>");
//                    response.end();
//                }
//            }
//        });
//
//        server.listen(4000, res -> {
//            if (res.succeeded()) {
//                System.out.println("Server is now listening!");
//            } else {
//                System.out.println("Failed to bind!");
//            }
//        });
    }

    @Override
    public void stop(Future<Void> future) throws Exception {

    }
}