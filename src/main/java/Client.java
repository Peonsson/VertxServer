//import io.vertx.core.AbstractVerticle;
//import io.vertx.core.Future;
//import io.vertx.core.buffer.Buffer;
//import io.vertx.core.http.HttpClient;
//
///**
// * Created by Peonsson on 17/12/15.
// */
//public class Client extends AbstractVerticle {
//
//    @Override
//    public void start(Future<Void> startFuture) throws Exception {
//        super.start(startFuture);
//
//        HttpClient client = vertx.createHttpClient();
//
//
//
//        client.websocket(4000, "localhost", "/", websocket -> {
//            websocket.handler(data -> {
//                System.out.println("Received data: " + data.toString("ISO-8859-1"));
////                client.close();
//            });
//            websocket.writeBinaryMessage(Buffer.buffer("HELLO WRRROLD"));
//            websocket.writeBinaryMessage(Buffer.buffer("HELLO WRRROLD"));
//            websocket.writeBinaryMessage(Buffer.buffer("HELLO WRRROLD"));
//            websocket.writeBinaryMessage(Buffer.buffer("HELLO WRRROLD"));
//
//        });
//    }
//}