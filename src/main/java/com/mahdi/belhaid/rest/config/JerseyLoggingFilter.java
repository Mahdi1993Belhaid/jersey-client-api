package com.mahdi.belhaid.rest.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class JerseyLoggingFilter implements ClientRequestFilter, ClientResponseFilter {
    private static final Log LOG = LogFactory.getLog(JerseyLoggingFilter.class);

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        LOG.info("Request: " + requestContext.getMethod() + " " + requestContext.getUri());

        requestContext.getHeaders().forEach((key, value) -> LOG.info("Header: " + key + " = " + value));
        if (requestContext.hasEntity()) {
            LOG.info("Request body: " + requestContext.getEntity().toString());
        }
    }

    @Override
    public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
        LOG.info("Response: " + responseContext.getStatus());
        responseContext.getHeaders().forEach((key, value) -> LOG.info("Header: " + key + " = " + value));
        if (responseContext.hasEntity()) {
            LOG.info("Response body: " + responseContext.getEntityStream().toString());
        }
    }
}
