package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.demo.pojo.project.Project;

@Mapper
public interface ProjectMapper {
    
    @Insert("insert into tb_project(project_name,manager_id,manager_name,priority,create_time,update_time) values(#{projectName},#{managerId},#{managerName},#{priority},#{createTime},#{updateTime})")
    public void addProject(Project newProject);

    @Results({
        @Result(column="project_id",property="projectId"),
        @Result(column="project_name",property="projectName"),
        @Result(column="manager_id",property="managerId"),
        @Result(column="manager_name",property="managerName"),
        @Result(column="project_status",property="projectStatus"),
        @Result(column="create_time",property="createTime"),
        @Result(column="update_time",property="updateTime")
    })
    @Select("Select * from tb_project where manager_id = #{id}")
    public List<Project> allProject(int id);
}
