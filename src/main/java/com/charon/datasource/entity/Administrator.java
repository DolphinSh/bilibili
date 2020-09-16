package com.charon.datasource.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Administrator {
    private Integer id;
    private String username;
    private String password;
    private Integer permission;
}
