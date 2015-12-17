package app; /**
 * Created by Peonsson on 17/12/15.
 */

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.eventbus.EventBus;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.handler.sockjs.BridgeOptions;
import io.vertx.ext.web.handler.sockjs.PermittedOptions;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;

public class Server extends AbstractVerticle {
    int counter = 0;

    @Override
    public void start(Future<Void> future) throws Exception {

        Router router = Router.router(getVertx());

        // define addresses
        BridgeOptions opts = new BridgeOptions()
                .addInboundPermitted(new PermittedOptions().setAddress("chat.to.server"))
                .addOutboundPermitted(new PermittedOptions().setAddress("chat.to.client"));

        // define path for messages
        SockJSHandler ebHandler = SockJSHandler.create(vertx).bridge(opts);
        router.route("/eventbus/*").handler(ebHandler);
        router.route().handler(StaticHandler.create());

        // listen to port 4000
        vertx.createHttpServer().requestHandler(router::accept).listen(4000);

        EventBus eb = vertx.eventBus();

        // add users to to eventbus
        eb.consumer("chat.to.server").handler(message -> {

            System.out.println("message" + counter++ + ": " + message.body().toString());

            // publish message to all subscribers
            eb.publish("chat.to.client", message.body().toString());
        });
    }
}
