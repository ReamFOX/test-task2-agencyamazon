package com.amazonagency.restapi.controller;

import java.time.Duration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
@EnableCaching
public class RedisConfig {

    @Bean
    public RedisCacheManager getCacheManager(RedisConnectionFactory connectionFactory) {
        return RedisCacheManager.builder()
                .cacheWriter(RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory))
                .withCacheConfiguration(
                        "by_asins_cache",
                        RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ZERO)
                )
                .withCacheConfiguration(
                        "by_dates_cache",
                        RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ZERO)
                )
                .withCacheConfiguration(
                        "total_cache",
                        RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ZERO)
                )
                .build();
    }
}
