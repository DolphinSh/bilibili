package com.charon.data;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@Slf4j
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 测试Redis是否成功引入并可用
     */
    @Test
    void test() {
        log.info(redisTemplate.getClass().toString());
        redisTemplate.opsForValue().set("key", "value");
        Object key = redisTemplate.opsForValue().get("key");
        if (key == null) {
            log.error("key is null");
        } else {
            log.info(key.toString());
        }
        //测试通过
    }
}
