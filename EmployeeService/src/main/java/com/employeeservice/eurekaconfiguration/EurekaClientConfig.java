package com.employeeservice.eurekaconfiguration;

import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.shared.transport.jersey.EurekaJerseyClientImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.security.KeyStore;

@Configuration
public class EurekaClientConfig {

        //@Value("${server.ssl.key-store}")
        private final String keyStorePath = "D:\\Learning_and_Development_Microservice\\NeoSoft_Service\\EmployeeService\\src\\main\\resources\\employee-service.p12";
        @Value("${server.ssl.key-store-type}")
        private String keystoreType;
        @Value("${server.ssl.key-store-password}")
        private String keyStorePassword;

        //@Value("${server.ssl.trust-store}")
        private final String trustStorePath = "D:\\Learning_and_Development_Microservice\\NeoSoft_Service\\EmployeeService\\src\\main\\resources\\employee-service.jks";
        @Value("${server.ssl.key-store-type}")
        private String trustStoreType;
        @Value("${server.ssl.trust-store-password}")
        private String trustStorePassword;

        @Bean
        public DiscoveryClient.DiscoveryClientOptionalArgs discoveryClientOptionalArgs() {
                try {
                        DiscoveryClient.DiscoveryClientOptionalArgs args = new DiscoveryClient.DiscoveryClientOptionalArgs();
                        EurekaJerseyClientImpl.EurekaJerseyClientBuilder builder = new EurekaJerseyClientImpl.EurekaJerseyClientBuilder();

                        System.setProperty("javax.net.ssl.keyStore", "D:\\Learning_and_Development_Microservice\\NeoSoft_Service\\EmployeeService\\src\\main\\resources\\employee-service.p12");
                        System.setProperty("javax.net.ssl.keyStorePassword", "ROOT123");
                        System.setProperty("javax.net.ssl.trustStore", "D:\\Learning_and_Development_Microservice\\NeoSoft_Service\\EmployeeService\\src\\main\\resources\\employee-service.jks");
                        System.setProperty("javax.net.ssl.trustStorePassword", "ROOT123");

                        builder.withClientName("employee-service");
                        builder.withSystemSSLConfiguration();
                        builder.withMaxTotalConnections(10);
                        builder.withMaxConnectionsPerHost(10);
                        args.setEurekaJerseyClient(builder.build());

                        SSLContext sslContext = SSLContext.getInstance("TLSv1.3");

                        //key-store properties
                        KeyStore keyStore = KeyStore.getInstance(this.keystoreType);
                        keyStore.load(this.getClass().getResourceAsStream(keyStorePath), keyStorePassword.toCharArray());

                        //trust-store properties
                        KeyStore trustStore = KeyStore.getInstance(this.trustStoreType);
                        trustStore.load(this.getClass().getResourceAsStream(trustStorePath), trustStorePassword.toCharArray());
                        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                        trustManagerFactory.init(trustStore);

                        //ssl context initialization
                        sslContext.init(null, trustManagerFactory.getTrustManagers(), null);
                        args.setSSLContext(sslContext);
                        return args;

                } catch (Exception e) {
                        throw new RuntimeException("cannot create bean for discovery client");
                }

        }
}
