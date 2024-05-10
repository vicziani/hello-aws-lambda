package hello;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HelloHandlerTest {

    @Mock
    Context context;

    @Mock
    LambdaLogger logger;

    @Test
    void handleRequest() {
        when(context.getLogger()).thenReturn(logger);

        var handler = new HelloHandler();
        var response = handler.handleRequest(new HelloRequest("John Doe"), context);
        assertEquals("Hello John Doe!", response.message());
        verify(logger).log(eq("Name: John Doe"));
    }
}