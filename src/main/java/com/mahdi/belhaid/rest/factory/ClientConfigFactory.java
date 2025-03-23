package com.mahdi.belhaid.rest.factory;


import com.mahdi.belhaid.rest.config.JerseyLoggingFilter;
import org.apache.hc.client5.http.impl.DefaultHttpRequestRetryStrategy;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
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
        CloseableHttpClient httpClient = HttpClients
                .custom()
                .setConnectionManager(connManager)
                .setRetryStrategy(new DefaultHttpRequestRetryStrategy(3, null)) // Retry 3 times
                .build();

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
