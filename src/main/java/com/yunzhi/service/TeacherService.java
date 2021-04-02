package com.yunzhi.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yunzhi.pojo.Teacher;
import com.yunzhi.pojo.TeacherQuery;

public interface TeacherService extends IService<Teacher> {
    //分页条件查询
    public void pageListQuery(Page<Teacher> pageParam, TeacherQuery query);
}
