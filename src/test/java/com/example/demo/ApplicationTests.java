package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
@Slf4j
class ApplicationTests {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Autowired
	RedisTemplate redisTemplate;

	@Autowired
	RedisConnectionFactory redisConnectionFactory;

	@Test
	void contextLoads() {
		Long aLong = jdbcTemplate.queryForObject("select count(*) from music", Long.class);
		log.info("music总数据量：{}", aLong);
	}

	@Test
	void testRedis() {
		ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
		stringStringValueOperations.set("redis", "ok");
		String redis = stringStringValueOperations.get("redis");
		log.info("redis: {}", redis);

		// 打印 redis 的连接工厂是用的 Lettuce 还是 jedis
		log.info(String.valueOf(redisConnectionFactory.getClass()));
	}
}
