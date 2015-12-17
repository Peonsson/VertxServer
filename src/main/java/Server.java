/**
 * Created by Peonsson on 17/12/15.
 */

import io.vertx.core.Context;
import io.vertx.core.Future;
import io.vertx.core.Verticle;
import io.vertx.core.Vertx;
import io.vertx.core.net.NetServer;

public class Server implements Verticle {

    @Override
    public Vertx getVertx() {
        return null;
    }

    @Override
    public void init(Vertx vertx, Context context) {

    }

    @Override
    public void start(Future<Void> future) throws Exception {

        Vertx vertx = Vertx.vertx();
        NetServer server = vertx.createNetServer();
        server.listen(0, "localhost", res -> {
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