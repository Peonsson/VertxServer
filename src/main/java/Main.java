import io.vertx.core.Vertx;

/**
 * Created by Peonsson on 17/12/15.
 */
public class Main {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new Server());
//        vertx.deployVerticle(new Client());
//        vertx.deployVerticle(new Client());
//        vertx.deployVerticle(new Client());
//        vertx.deployVerticle(new Client());
    }
}
