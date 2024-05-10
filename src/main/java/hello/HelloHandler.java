package hello;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class HelloHandler implements RequestHandler<HelloRequest, HelloResponse> {

    @Override
    public HelloResponse handleRequest(HelloRequest helloRequest, Context context) {
        var logger = context.getLogger();
        logger.log("Name: %s".formatted(helloRequest.name()));
        return new HelloResponse("Hello %s!".formatted(helloRequest.name()));
    }
}
