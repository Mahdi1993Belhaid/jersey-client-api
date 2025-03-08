package com.mahdi.belhaid.rest.factory;

import org.glassfish.jersey.client.proxy.WebResourceFactory;

import javax.ws.rs.client.WebTarget;
import java.util.HashMap;
import java.util.Map;

public final class ApiClientFactory {
    private static final Map<Class<?>, Object> SINGLETON_SERVICE_FACTORY_MAP = new HashMap<>();

    private ApiClientFactory(){}
    public static <T> T createClient(Class<T> proxyInterface, String serviceName) {
        if (SINGLETON_SERVICE_FACTORY_MAP.containsKey(proxyInterface))
        {
            return (T) SINGLETON_SERVICE_FACTORY_MAP.get(proxyInterface);
        }
        WebTarget jerseyClient = ClientConfigFactory.createJerseyClient(serviceName);
        final T client = WebResourceFactory.newResource(proxyInterface, jerseyClient);
        SINGLETON_SERVICE_FACTORY_MAP.put(proxyInterface, client);
        return client ;
    }
}



