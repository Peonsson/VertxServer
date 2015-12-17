/**
 * Created by Peonsson on 17/12/15.
 */

import io.vertx.core.*;
import io.vertx.core.net.NetServer;
import io.vertx.core.net.NetServerOptions;

public class Server extends AbstractVerticle {

    @Override
    public void start(Future<Void> future) throws Exception {
        // Create server
        NetServer server = vertx.createNetServer();

        // If 0 is used as the listening port, the server will find an unused random port to listen on.
        server.listen(4000, "localhost", res -> {
            if (res.succeeded()) {
                System.out.println("Server is now listening on actual port: " + server.actualPort());
            } else {
                System.out.println("Failed to bind!");
            }
        });

    }

    @Override
    public void stop(Future<Void> future) throws Exception {

    }
}