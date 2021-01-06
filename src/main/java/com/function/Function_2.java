package com.function;

import java.util.Optional;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;

/**
 * Azure Functions with HTTP Trigger.
 */
public class Function_2 {
    /**
     * This function listens at endpoint "/api/Function_2". Two ways to invoke it
     * using "curl" command in bash: 1. curl -d "HTTP Body" {your
     * host}/api/Function_2 2. curl {your host}/api/Function_2?name=HTTP%20Query
     */
    @FunctionName("functionqueryparamter")
    public HttpResponseMessage runQuery(@HttpTrigger(name = "req", methods = {
            HttpMethod.GET }, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<Integer>> request,
            final ExecutionContext context) {
        context.getLogger().info("INFO => " + request.getQueryParameters());

        try {

            // Parse query parameter
            int query = Integer.parseInt(request.getQueryParameters().get("numero"));
            int numero = request.getBody().orElse(query);

            if (numero < 5) {
                return request.createResponseBuilder(HttpStatus.OK).body(numero).build();
            } else {
                return request.createResponseBuilder(HttpStatus.NOT_FOUND).body(numero).build();
            }

        } catch (Exception e) {
            return request.createResponseBuilder(HttpStatus.BAD_REQUEST).build();
        }

    }
}
