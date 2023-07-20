package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clazz {
    private Integer cid;
    private String cname;
    //一个班级对应多名学生
    private List<Student1> students;
}
