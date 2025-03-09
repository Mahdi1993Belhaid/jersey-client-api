package com.mahdi.belhaid.rest.factory;

import org.glassfish.jersey.client.proxy.WebResourceFactory;

import javax.ws.rs.client.WebTarget;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ApiClientFactory {
    private static final Map<Class<?>, Object> SINGLETON_SERVICE_FACTORY_MAP = new ConcurrentHashMap<>();

    private ApiClientFactory(){}
    public static <T> T createClient(Class<T> proxyInterface, String serviceName) {

        return (T) SINGLETON_SERVICE_FACTORY_MAP.computeIfAbsent(proxyInterface, key -> {
            WebTarget jerseyClient = ClientConfigFactory.createJerseyClient(serviceName);
            return WebResourceFactory.newResource(proxyInterface, jerseyClient);
        });
    }
}



