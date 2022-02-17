package org.forex.rates.configuration;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "org.forex.rates")
public class ClientConfiguration {
}
