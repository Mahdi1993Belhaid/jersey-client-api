package com.mahdi.belhaid.rest.factory;

import com.mahdi.belhaid.rest.exceptions.LoadPropertiesException;
import java.io.FileInputStream;
import java.util.Properties;

public class ClientProperties {
    private static final String CONNECT_TIMEOUT = "connecttimeout";
    private static final String READ_TIMEOUT = "readtimeout";
    private static final String BASEURL = "baseurl";
    protected static final Properties propriete = new Properties();
    private  int connectTimeOut;
    private  int readTimeout;
    private   String host ;
    public  ClientProperties(String prefix){
       setProperties(prefix);
   }

    public int getConnectTimeOut() {
        return connectTimeOut;
    }

    public void setConnectTimeOut(int connectTimeOut) {
        this.connectTimeOut = connectTimeOut;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public String getBaseUrl() {
        return host;
    }

    public void setBaseUrl(String baseUrl) {
        this.host = baseUrl;
    }

    private  void setProperties(String prefix)  {
       try(FileInputStream fileInputStream = new FileInputStream(ClassLoader.getSystemResource("application.properties").getFile())) {
           propriete.load(fileInputStream);
           connectTimeOut = Integer.parseInt(propriete.getProperty(prefix+CONNECT_TIMEOUT));
           readTimeout = Integer.parseInt(propriete.getProperty(prefix+READ_TIMEOUT));
           host = propriete.getProperty(prefix+BASEURL);
       }catch (Exception e){
           throw  new LoadPropertiesException(e.getMessage());
       }
   }

}
