package com.example.demo000.controller;


import com.example.demo000.entity.Grade;
import com.example.demo000.mapper.GradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class GradeController {
    @Autowired
    GradeMapper gradeMapper;

    //查询所有信息
    @RequestMapping("/getallgrade")
    public List<Grade> getAllGrade() {
        return gradeMapper.getallgrade();
    }

    //搜索
    @RequestMapping("/searchgrade")
    public List<Grade> searchgrade(@RequestBody Grade grade){
        return gradeMapper.searchgrade(grade);
    }

    //修改
    @RequestMapping("/upgrade")
    public int upgrade(@RequestBody Grade grade){
        if(grade.getGrade()>=60){
            grade.setCredit(2);
            grade.setGradepoint(grade.getGrade()/10-6);
        }
        else {
            grade.setCredit(0);
            grade.setGradepoint(0);
        }
        return gradeMapper.updateGrade(grade);
    }
}
