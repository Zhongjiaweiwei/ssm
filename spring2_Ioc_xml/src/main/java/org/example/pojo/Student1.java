package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student1 {
    private Integer sid;
    private String sname;
    private Integer age;
    private String gender;
    //一个学生对应一个班级
    private Clazz clazz;
    //爱好
    private String[] hobby;
    //对应的老师
    private Map<String,Teacher> teacherMap;
}
