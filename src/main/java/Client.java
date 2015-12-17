import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpClient;

/**
 * Created by Peonsson on 17/12/15.
 */
public class Client extends AbstractVerticle {

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        super.start(startFuture);

        HttpClient client = vertx.createHttpClient();
    }
}
