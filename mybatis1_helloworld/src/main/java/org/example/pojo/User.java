package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//添加get/set方法
@NoArgsConstructor//添加无参构造方法
@AllArgsConstructor//添加全参构造方法
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String gender;
    private String email;
}
