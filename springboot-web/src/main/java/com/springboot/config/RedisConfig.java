package com.springboot.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 
 * <p>
 * Title: RedisConfig
 * </p>
 * <p>
 * Description:Redis配置类
 * </p>
 * <p>
 * Company: xxx
 * </p>
 * 
 * @author Mr.yang
 * @date 2018年9月25日 下午2:55:11
 */
@Configuration
@EnableCaching
@PropertySource("classpath:redis.properties")
public class RedisConfig extends CachingConfigurerSupport {
	/**
	 * 
	 * 管理缓存
	 * 
	 * @param redisTemplate
	 * @return
	 */
	@Bean
	public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
		CacheManager cacheManager = new RedisCacheManager(redisTemplate);
		return cacheManager;
	}

	/**
	 * RedisTemplate模板配置
	 * 
	 * @param factory
	 * @return
	 */
	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
		redisTemplate.setConnectionFactory(factory);
		return redisTemplate;
	}

}
