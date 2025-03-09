package com.mahdi.belhaid;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mahdi.belhaid.rest.config.ObjectMapperFactory;
import com.mahdi.belhaid.rest.factory.ApiClientFactory;
import com.mahdi.belhaid.rest.factory.ClientConfigFactory;
import com.mahdi.belhaid.rest.factory.ClientProperties;
import com.mahdi.belhaid.rest.interfaces.Csvaps05SynchroneInterface;
import org.junit.jupiter.api.Test;

import javax.security.auth.callback.Callback;
import javax.ws.rs.client.WebTarget;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

public class MyTest {

    @Test
    public void test() throws InterruptedException, ExecutionException {

        ExecutorService service = Executors.newFixedThreadPool(10);
        List<Callable<Object>> list = new ArrayList<>();
        Callable<Object> callback = () -> {return ApiClientFactory.createClient(Csvaps05SynchroneInterface.class,"service");};
        List<Csvaps05SynchroneInterface> objects = new ArrayList<>();
        for(int i=0;i<100;i++){
          list.add(callback);
        }
       List<Future<Object>>futurs = service.invokeAll(list);
        for(Future<Object> future:futurs){
            objects.add((Csvaps05SynchroneInterface) future.get());
        }
        service.shutdown();
        service.awaitTermination(1,TimeUnit.MINUTES);
        objects.forEach(c -> System.out.println(c.hashCode()));


    }


}
