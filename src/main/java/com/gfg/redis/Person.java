package com.gfg.redis;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    private long id;
    private String name;
    private int age;
    private String email;

}
