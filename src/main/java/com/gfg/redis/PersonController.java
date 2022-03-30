package com.gfg.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class PersonController {

    private static String PERSON_KEY_PREFIX = "person::";

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @PostMapping("/set_value")
    public void setValue(@RequestBody Person person){
        String key = PERSON_KEY_PREFIX + person.getId();
        redisTemplate.opsForValue().set(key, person);
    }

    @GetMapping("/get_value")
    public Person getValue(@RequestParam("id") int id){
        return null;
    }

    @PostMapping("/lpush")
    public void lPush(@RequestBody Person person){

    }

    @PostMapping("/rpush")
    public void rPush(@RequestBody Person person){

    }

    @GetMapping("/lrange")
    public List<Person> lRange(@RequestParam("start") int start, @RequestParam("stop") int stop){
        return null;
    }



}
