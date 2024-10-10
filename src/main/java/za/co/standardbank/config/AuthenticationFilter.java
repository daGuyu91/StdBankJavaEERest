package za.co.standardbank.config;

import jakarta.annotation.Priority;


import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.Base64;

@Provider
@Priority(1000)
public class AuthenticationFilter implements javax.ws.rs.container.ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String authHeader = requestContext.getHeaderString("Authorization");
        System.out.println("Auth header ===+++++++++++++++++++++++++++++++ " + authHeader);
        if ("DELETE".equalsIgnoreCase(requestContext.getMethod())) {
            if (authHeader == null || !authHeader.startsWith("Basic ")) {
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
                return;
            }

            // Decode the username and password
            System.out.println("Auth header: " + authHeader);
            String encodedCredentials = authHeader.substring("Basic ".length()).trim();
            String credentials = new String(Base64.getDecoder().decode(encodedCredentials));
            String[] values = credentials.split(":", 2);
            String username = values[0];
            String password = values[1];

            // Validate credentials
            if (!"user".equals(username) || !"password".equals(password)) {
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
            }
        }
    }
}
