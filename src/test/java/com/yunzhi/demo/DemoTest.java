package com.yunzhi.demo;

import com.yunzhi.mapper.TeacherMapper;
import com.yunzhi.pojo.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.yunzhi.mapper")
public class DemoTest {

    //注入TeacherMapper
    @Autowired
    private TeacherMapper teacherMapper;
    @Test
    public  void   testAdd(){
        Teacher teacher = new Teacher();
        teacher.setName("阿黄");
        teacher.setIntro("菜鸟讲师");
        teacherMapper.insert(teacher);
    }

    @Test
    public  void testSelect(){
        //根据id查询
        Teacher teacher = teacherMapper.selectById(12);
        System.out.println(teacher);

    }

    @Test
    public  void testUpdate(){
        //根据id查询
        Teacher teacher = teacherMapper.selectById("1373907180364873729");
        teacher.setName("tom");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        teacherMapper.updateById(teacher);
    }

}
