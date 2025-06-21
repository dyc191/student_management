package com.example.demo000.mapper;

import com.example.demo000.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    //查询所有学生信息
    @Select("select * from studentinformation")
    List<Student> getall();

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
    List<Student> searchstu(Student student);

    //删除学生信息
    @Delete("delete from studentinformation where stuid=#{stuid}")
    int DelStu(int stuid);

    //添加学生信息
    @Insert("insert into studentinformation values(null,#{stuname},#{stusex},#{stuage},#{stuphone},#{imgpath},null,null,null)")
    int addStu(Student stu);

    //修改学生信息
    @Update("update studentinformation set stuname=#{stuname},stusex=#{stusex},stuage=#{stuage}," +
            "stuphone=#{stuphone},imgpath=#{imgpath} where stuid=#{stuid}")
    int updateStu(Student stu);
}
