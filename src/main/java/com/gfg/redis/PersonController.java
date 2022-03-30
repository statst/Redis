package com.gfg.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

public class PersonController {

    private static String PERSON_KEY_PREFIX = "person::";
    private static String PERSON_LIST_KEY = "person_list::";

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @PostMapping("/set_value")
    public void setValue(@RequestBody Person person){
        String key = PERSON_KEY_PREFIX + person.getId();
        redisTemplate.opsForValue().set(key, person);
    }

    @GetMapping("/get_value")
    public Person getValue(@RequestParam("id") int id){
        String key = PERSON_KEY_PREFIX + id;
        return (Person) redisTemplate.opsForValue().get(key);
    }

    @PostMapping("/lpush")
    public void lPush(@RequestBody Person person){
        redisTemplate.opsForList().leftPush(PERSON_LIST_KEY, person);
    }

    @PostMapping("/rpush")
    public void rPush(@RequestBody Person person){
        redisTemplate.opsForList().rightPush(PERSON_LIST_KEY, person);
    }

    @GetMapping("/lrange")
    public List<Person> lRange(@RequestParam("start") int start, @RequestParam("stop") int stop){
        List<Object> peopleList = redisTemplate.opsForList().range(PERSON_LIST_KEY, start, stop);
        List<Person> personList = new ArrayList<>();

        for(int i=0; i< peopleList.size(); i++){
            personList.add((Person) peopleList.get(i));
        }

        return personList;
    }



}
