package com.departmentservice.feignconfiguration;

import feign.Client;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import java.security.KeyStore;
import java.security.SecureRandom;

@Configuration
public class FeignConfiguration {

    @Value("${server.ssl.key-store}")
    private String keystorePath;

    @Value("${server.ssl.key-store-type}")
    private String keystoreType;

    @Value("${server.ssl.key-store-password}")
    private String keystorePassword;

    @Value("${server.ssl.trust-store}")
    private Resource trustStore;
    @Value("${server.ssl.trust-store-password}")
    private String trustStorePassword;

    @Autowired
    private ResourceLoader resourceLoader;

    @Bean
    public Client feignClient() {

        return new Client.Default(getSSLSocketFactory(), new NoopHostnameVerifier());
    }

    private SSLSocketFactory getSSLSocketFactory() {
        try {
            KeyStore keyStore = KeyStore.getInstance(this.keystoreType);
            keyStore.load(this.resourceLoader.getResource(this.keystorePath).getInputStream(), this.keystorePassword.toCharArray());
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, keystorePassword.toCharArray());

            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(this.trustStore.getInputStream(), trustStorePassword.toCharArray());
            trustManagerFactory.init(trustStore);

            SSLContext sslContext = SSLContext.getInstance("TLSv1.3");
            sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), new SecureRandom());

            return sslContext.getSocketFactory();
        } catch (Exception e) {
            throw new RuntimeException("failed to create the socket factory", e);
        }
    }

}