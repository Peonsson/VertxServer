import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientOptions;

/**
 * Created by Peonsson on 17/12/15.
 */
public class Client extends AbstractVerticle {

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        super.start(startFuture);

        HttpClientOptions options = new HttpClientOptions().setDefaultPort(4000).setDefaultHost("localhost");
        HttpClient client = vertx.createHttpClient(options);

        client.getNow(4000, "localhost", "/",response -> {

            response.bodyHandler(totalBuffer -> {
                // Now all the body has been read
                System.out.println("Total response body length is " + totalBuffer.length());
                System.out.println("data is:" + totalBuffer.toString());
            });
        });
    }
}