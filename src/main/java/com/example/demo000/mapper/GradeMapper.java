package com.example.demo000.mapper;

import com.example.demo000.entity.Grade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface GradeMapper {

    //查询所有学生信息
    @Select("select * from studentinformation")
    List<Grade> getallgrade();

    //搜索学生
    @Select("<script>" +
            "SELECT * FROM studentinformation " +
            "WHERE 1=1 " +
            "<if test='stuid != null and stuid != \"\"'>" +
            "  AND stuid LIKE CONCAT('%', #{stuid}, '%') " +
            "</if>" +
            "<if test='stuname != null and stuname != \"\"'>" +
            "  AND stuname LIKE CONCAT('%', #{stuname}, '%') " +
            "</if>" +
            "</script>")//stuid为主键，查询时stuid为空会出错，运用动态SQL语句
    List<Grade> searchgrade(Grade grade);

    //修改学生信息
    @Update("update studentinformation set grade=#{grade},credit=#{credit},gradepoint=#{gradepoint}" +
            "where stuid=#{stuid}" )
    int updateGrade(Grade grade);
}
