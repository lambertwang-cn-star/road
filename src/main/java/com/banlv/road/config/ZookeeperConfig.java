package com.banlv.road.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author tanmin
 */
@Configuration
@Data
public class ZookeeperConfig {
    @Value("${zoo.host}")
    private String host;

    @Value("${zoo.port}")
    private String port;
}
