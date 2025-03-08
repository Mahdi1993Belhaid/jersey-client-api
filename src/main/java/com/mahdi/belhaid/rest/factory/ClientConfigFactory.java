package com.mahdi.belhaid.rest.factory;


import com.mahdi.belhaid.rest.config.JerseyLoggingFilter;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.glassfish.jersey.client.ClientConfig;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
public class ClientConfigFactory {

    private static final String PREFIX = "rest.client.";

    private ClientConfigFactory(){}
    public static WebTarget createJerseyClient(String serviceName){
        ClientProperties clientProperties = new ClientProperties(PREFIX+serviceName+".");
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
        connManager.setMaxTotal(100);
        connManager.setDefaultMaxPerRoute(20);
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.register(JerseyLoggingFilter.class);
        Client client =  ClientBuilder.newBuilder()
                .withConfig(clientConfig)
                .property("jersey.config.client.connectTimeout", clientProperties.getConnectTimeOut())
                .property("jersey.config.client.readTimeout", clientProperties.getReadTimeout())
                .build();
         return client.target(clientProperties.getBaseUrl());
    }
}
