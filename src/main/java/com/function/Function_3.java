package com.function;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;

import org.json.JSONObject;

/**
 * Azure Functions with HTTP Trigger.
 */
public class Function_3 {
    /**
     * This function listens at endpoint "/api/Function_3". Two ways to invoke it
     * using "curl" command in bash: 1. curl -d "HTTP Body" {your
     * host}/api/Function_3 2. curl {your host}/api/Function_3?name=HTTP%20Query
     */
    @FunctionName("functionjsonname")
    public HttpResponseMessage runJson(
            @HttpTrigger(name = "req", methods = {
                    HttpMethod.POST }, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<String> request,
            final ExecutionContext context) {
        context.getLogger().info("INFO => " + request.getBody());

        try {

            JSONObject json = new JSONObject(request.getBody());
            String jsonName = json.getString("nome");

            if (jsonName.equalsIgnoreCase("joão") || jsonName.equalsIgnoreCase("josé")
                    || jsonName.equalsIgnoreCase("joaquim")) {
                return request.createResponseBuilder(HttpStatus.OK).body(jsonName).build();
            } else {
                return request.createResponseBuilder(HttpStatus.BAD_REQUEST).body(jsonName).build();
            }

        } catch (Exception e) {
            return request.createResponseBuilder(HttpStatus.BAD_REQUEST).build();
        }

    }
}
