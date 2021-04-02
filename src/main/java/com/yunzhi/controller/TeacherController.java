package com.yunzhi.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunzhi.pojo.Teacher;
import com.yunzhi.pojo.TeacherQuery;
import com.yunzhi.pojo.result.Result;
import com.yunzhi.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public Result saveTeacher(@RequestBody Teacher teacher){

        boolean save = teacherService.save(teacher);
        if (save){
            return Result.ok();
        }else {
            return Result.error();
        }
    }

    //查询所有
    @GetMapping
    public Result selectAll(){
//          int i = 1/0;
        List<Teacher> list = teacherService.list(null);
        return Result.ok().data("items",list);
    }

    //根据id修改
    @PutMapping("{id}")
    public Result updateById(@PathVariable String id,@RequestBody Teacher teacher){
        teacher.setId(id);
        boolean save = teacherService.updateById(teacher);
        if (save){
            return Result.ok().message("修改成功");
        }else {
            return Result.error().message("修改失败");
        }
    }

    //根据id删除
    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable String id){
        boolean b = teacherService.removeById(id);
        if (b){
            return Result.ok().message("删除成功");
        }else {
            return Result.error().message("删除失败");
        }
    }

    //分页查询
    @GetMapping("{page}/{limit}")
    public Result pageList(@PathVariable Long page,@PathVariable Long limit){
        Page<Teacher> pageParam = new Page<>(page, limit);
        teacherService.page(pageParam,null);
        //查询某一页的数据
        List<Teacher> list = pageParam.getRecords();
        //查询总记录数
        long total = pageParam.getTotal();
        System.out.println(total+"=================");
        return Result.ok().data("total",total).data("rows",list);
    }

    //分页条件查询
    @PostMapping("{page}/{limit}")
    public Result pageListQuery(@PathVariable Long page, @PathVariable Long limit,
                                @RequestBody TeacherQuery query){
        Page<Teacher> pageParam = new Page<>(page, limit);

        teacherService.pageListQuery(pageParam,query);

        //查询某一页的数据
        List<Teacher> list = pageParam.getRecords();
        //查询总记录数
        long total = pageParam.getTotal();
        System.out.println(total+"=================");
        return Result.ok().data("total",total).data("rows",list);
    }

}
