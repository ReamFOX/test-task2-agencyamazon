package com.amazonagency.restapi.config;

import java.time.Duration;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${redis.cache.lifetime}")
    private int cacheLifetime;

    @Bean
    RedisCacheConfiguration cacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(cacheLifetime));
    }

    @Bean
    public RedisCacheManager getCacheManager(RedisConnectionFactory connectionFactory) {
        return RedisCacheManager.builder()
                .cacheWriter(RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory))
                .withCacheConfiguration("by_asins_cache", cacheConfiguration())
                .withCacheConfiguration("by_dates_cache", cacheConfiguration())
                .withCacheConfiguration("total_cache", cacheConfiguration())
                .build();
    }
}
