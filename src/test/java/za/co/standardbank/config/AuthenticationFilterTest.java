/*
package za.co.standardbank.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Base64;

import static org.mockito.Mockito.*;

public class AuthenticationFilterTest {

    private AuthenticationFilter authenticationFilter;
    private ContainerRequestContext requestContext;

    @BeforeEach
    public void setUp() {
        authenticationFilter = new AuthenticationFilter();
        requestContext = Mockito.mock(ContainerRequestContext.class);
    }

    @Test
    public void testFilter_ValidBasicAuth_DeleteRequest() throws IOException {
        String username = "user";
        String password = "password";
        String authHeader = "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes());

        when(requestContext.getHeaderString("Authorization")).thenReturn(authHeader);
        when(requestContext.getMethod()).thenReturn("DELETE");

        authenticationFilter.filter(requestContext);

        // Verify that the request is not aborted
        verify(requestContext, never()).abortWith(any(Response.class));
    }

    @Test
    public void testFilter_InvalidUsername_DeleteRequest() throws IOException {
        String authHeader = "Basic " + Base64.getEncoder().encodeToString(("wrongUser:wrongPassword").getBytes());

        when(requestContext.getHeaderString("Authorization")).thenReturn(authHeader);
        when(requestContext.getMethod()).thenReturn("DELETE");

        authenticationFilter.filter(requestContext);

        // Verify that the request is aborted with UNAUTHORIZED response
        verify(requestContext).abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
    }

    //@Test
    public void testFilter_MissingAuthHeader_DeleteRequest() throws IOException {
        when(requestContext.getHeaderString("Authorization")).thenReturn(null);
        when(requestContext.getMethod()).thenReturn("DELETE");

        authenticationFilter.filter(requestContext);

        // Verify that the request is aborted with UNAUTHORIZED response
        verify(requestContext).abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
    }

    @Test
    public void testFilter_NonDeleteRequest() throws IOException {
        String username = "user";
        String password = "password";
        String authHeader = "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes());

        when(requestContext.getHeaderString("Authorization")).thenReturn(authHeader);
        when(requestContext.getMethod()).thenReturn("GET");

        authenticationFilter.filter(requestContext);

        // Verify that the request is not aborted for non-DELETE methods
        verify(requestContext, never()).abortWith(any(Response.class));
    }
}
*/
