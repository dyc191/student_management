package com.example.demo000.controller;

import com.example.demo000.entity.Student;
import com.example.demo000.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class StudentController {
    @Autowired
    StudentMapper studentMapper;

    //查询所有学生信息
    @RequestMapping("/getall")
    public List<Student> getAllStudent() {
        return studentMapper.getall();
    }

    //搜索学生
    @RequestMapping("/searchstu")
    public List<Student> searchstu(@RequestBody  Student student){
        return studentMapper.searchstu(student);
    }

    //删除学生信息
    @RequestMapping("/delstu")
    public int delstu(int stuid){
        return studentMapper.DelStu(stuid);
    }

    //添加学生信息
    @RequestMapping("/addstu")
    public int addstu(@RequestBody Student stu){
        if(stu.getStuname()==""||stu.getStusex()==""){
            return 0;
        }
        else {
            return studentMapper.addStu(stu);
        }
    }

    //修改学生信息
    @RequestMapping("/upstu")
    public int upstu(@RequestBody Student stu){
        if(stu.getStuname()==""||stu.getStusex()==""){
            return 0;
        }else{
            return studentMapper.updateStu(stu);
        }
    }
}
