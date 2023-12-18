package com.christech;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPEvent
import io.micronaut.function.aws.proxy.payload2.APIGatewayV2HTTPEventFunction
import io.micronaut.http.HttpMethod
import io.micronaut.function.aws.proxy.MockLambdaContext
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HomeControllerTest {

    @Test
    fun testHandler() {
        val handler = APIGatewayV2HTTPEventFunction()
        val request = APIGatewayV2HTTPEvent()
        request.requestContext = APIGatewayV2HTTPEvent.RequestContext.builder()
            .withHttp(APIGatewayV2HTTPEvent.RequestContext.Http.builder()
                .withPath("/")
                .withMethod(HttpMethod.GET.toString())
                .build()
            ).build()
        val response = handler.handleRequest(request, MockLambdaContext())

        assertEquals(200, response.statusCode)
        assertEquals("{\"message\":\"Hello World\"}", response.body)
        handler.applicationContext.close()
    }
}

