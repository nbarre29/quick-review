-> This is self signed ssl, not CA certificate, but still it's good to know how self signed ssl works just in case

mvn spring-boot:run


http://localhost:8443/hello
Bad Request
This combination of host and port requires TLS.

https://localhost:8443/hello


________________________________________________________________________
REFERENCES:
https://www.youtube.com/watch?v=rm9OKTSm-4A
https://github.com/TechPrimers/spring-boot-https-example/tree/master

________________________________________________________________________


C:\Users\navee\OneDrive\Desktop\Cleanup>keytool -genkey -alias https-example -storetype JKS -keyalg RSA -keysize 2048 -validity 365 -keystore https-example.jks
Enter keystore password:
Re-enter new password:
Enter the distinguished name. Provide a single dot (.) to leave a sub-component empty or press ENTER to use the default value in braces.
What is your first and last name?
  [Unknown]:  Spring Boot
What is the name of your organizational unit?
  [Unknown]:  Technology
What is the name of your organization?
  [Unknown]:  TechPrimers
What is the name of your City or Locality?
  [Unknown]:  Bangalore
What is the name of your State or Province?
  [Unknown]:  Karnataka
What is the two-letter country code for this unit?
  [Unknown]:  IN
Is CN=Spring Boot, OU=Technology, O=TechPrimers, L=Bangalore, ST=Karnataka, C=IN correct?
  [no]:  yes

Generating 2,048 bit RSA key pair and self-signed certificate (SHA384withRSA) with a validity of 365 days
        for: CN=Spring Boot, OU=Technology, O=TechPrimers, L=Bangalore, ST=Karnataka, C=IN
Enter key password for <https-example>
        (RETURN if same as keystore password):

Warning:
The JKS keystore uses a proprietary format. It is recommended to migrate to PKCS12 which is an industry standard format using "keytool -importkeystore -srckeystore https-example.jks -destkeystore https-example.jks -deststoretype pkcs12".

C:\Users\navee\OneDrive\Desktop\Cleanup>keytool -list -keystore https-example.jks
Enter keystore password:
Keystore type: JKS
Keystore provider: SUN

Your keystore contains 1 entry

https-example, Jul 14, 2025, PrivateKeyEntry,
Certificate fingerprint (SHA-256): 93:39:37:0E:FB:9C:6F:41:8E:8C:36:76:71:61:C7:84:41:5F:8B:F8:BE:ED:D2:26:81:64:A4:6F:E6:B2:BE:02

Warning:
The JKS keystore uses a proprietary format. It is recommended to migrate to PKCS12 which is an industry standard format using "keytool -importkeystore -srckeystore https-example.jks -destkeystore https-example.jks -deststoretype pkcs12".

C:\Users\navee\OneDrive\Desktop\Cleanup>keytool -list -v -keystore https-example.jks
Enter keystore password:
Keystore type: JKS
Keystore provider: SUN

Your keystore contains 1 entry

Alias name: https-example
Creation date: Jul 14, 2025
Entry type: PrivateKeyEntry
Certificate chain length: 1
Certificate[1]:
Owner: CN=Spring Boot, OU=Technology, O=TechPrimers, L=Bangalore, ST=Karnataka, C=IN
Issuer: CN=Spring Boot, OU=Technology, O=TechPrimers, L=Bangalore, ST=Karnataka, C=IN
Serial number: 26d882524d096702
Valid from: Mon Jul 14 18:52:57 EDT 2025 until: Tue Jul 14 18:52:57 EDT 2026
Certificate fingerprints:
         SHA1: 2F:63:9D:69:27:23:5E:BF:4E:22:DE:79:8D:FE:75:AF:B0:5F:7A:22
         SHA256: 93:39:37:0E:FB:9C:6F:41:8E:8C:36:76:71:61:C7:84:41:5F:8B:F8:BE:ED:D2:26:81:64:A4:6F:E6:B2:BE:02
Signature algorithm name: SHA384withRSA
Subject Public Key Algorithm: 2048-bit RSA key
Version: 3

Extensions:

#1: ObjectId: 2.5.29.14 Criticality=false
SubjectKeyIdentifier [
KeyIdentifier [
0000: B0 FC 94 64 20 76 E5 95   13 35 36 64 09 55 37 EF  ...d v...56d.U7.
0010: 7E 85 C8 8A                                        ....
]
]



*******************************************
*******************************************



Warning:
The JKS keystore uses a proprietary format. It is recommended to migrate to PKCS12 which is an industry standard format using "keytool -importkeystore -srckeystore https-example.jks -destkeystore https-example.jks -deststoretype pkcs12".

________________________________________________________________________


package com.techprimers.https;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;

@Configuration
public class RestTemplateConfig {

    @Value("${server.ssl.trust-store}")
    private Resource trustStore;

    @Value("${server.ssl.trust-store-password}")
    private String trustStorePassword;

    @Value("${server.ssl.trust-store-type:JKS}")
    private String trustStoreType;

    @Bean
    public RestTemplate restTemplate() throws Exception {
        SSLContext sslContext = SSLContextBuilder.create()
                .loadTrustMaterial(trustStore.getURL(), trustStorePassword.toCharArray())
                .build();

        SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext);
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(socketFactory)
                .build();

        HttpComponentsClientHttpRequestFactory factory =
                new HttpComponentsClientHttpRequestFactory(httpClient);

        return new RestTemplate(factory);
    }
}


-> 2. SecurityConfig.java
This configures Spring Security to allow all requests without authentication (not for production use).

package com.techprimers.https;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/**").permitAll()
            )
            .csrf(csrf -> csrf.disable()); // Disable CSRF for non-browser clients

        return http.build();
    }
}


3)  Add to pom.xml if missing
Make sure you include the following dependencies in your pom.xml:

<!-- Apache HttpClient for custom RestTemplate -->
<dependency>
    <groupId>org.apache.httpcomponents.client5</groupId>
    <artifactId>httpclient5</artifactId>
    <version>5.3</version>
</dependency>

<!-- Spring Security (already included in Spring Boot starter if you're using security) -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>










