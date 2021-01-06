package com.function;

import java.util.Optional;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.BindingName;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;

/**
 * Azure Functions with HTTP Trigger.
 */
public class Function_1 {
    /**
     * This function listens at endpoint "/api/HttpExample". Two ways to invoke it
     * using "curl" command in bash: 1. curl -d "HTTP Body" {your
     * host}/api/HttpExample 2. curl "{your host}/api/HttpExample?name=HTTP%20Query"
     */
    @FunctionName("functionpathparamter")
    public HttpResponseMessage runPath(@HttpTrigger(name = "req", methods = {
            HttpMethod.GET }, authLevel = AuthorizationLevel.ANONYMOUS, route = "functionpathparamter/{numero}") HttpRequestMessage<Optional<String>> req,
            @BindingName("numero") String numero, final ExecutionContext context) {
        context.getLogger().info("INFO => " + req.getUri().toString());

        try {

            int num = Integer.parseInt(numero);

            if (num < 5) {
                return req.createResponseBuilder(HttpStatus.OK).body(numero).build();
            } else {
                return req.createResponseBuilder(HttpStatus.BAD_REQUEST).body(numero).build();
            }

        } catch (Exception e) {
            return req.createResponseBuilder(HttpStatus.BAD_REQUEST).build();
        }
    }

}
