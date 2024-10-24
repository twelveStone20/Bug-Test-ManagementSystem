package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.demo.pojo.test.usecaselibrary.UsecaseLibrary;

@Mapper
public interface UsecaseLibMapper {
    @Insert("insert into tb_usecaselibrary(usecaselib_name,usecaselib_relate_team_id,usecaselib_creator_id,usecaselib_creator_name) values(#{usecaseLibraryName},#{libRelateTeamId},#{libCreatorId},#{libCreatorName})")
    public void addUsecaseLibrary(UsecaseLibrary newUsecaseLib);

    @Results({
        @Result(column="usecaselib_id",property="usecaseLibraryId"),
        @Result(column="usecaselib_name",property="usecaseLibraryName"),
        @Result(column="usecaselib_casenumber",property="usecaseNumber"),
        @Result(column="usecaselib_relate_team_id",property="libRelateTeamId"),
        @Result(column="usecaselib_creator_id",property="libCreatorId"),
        @Result(column="usecaselib_creator_name",property="libCreatorName")
    })
    @Select("select * from tb_usecaselibrary where usecaselib_relate_team_id = #{teamId}")
    public List<UsecaseLibrary> allUsecaseLibrary(int id);
    
    @Results({
        @Result(column="usecaselib_id",property="usecaseLibraryId"),
        @Result(column="usecaselib_name",property="usecaseLibraryName"),
        @Result(column="usecaselib_casenumber",property="usecaseNumber"),
        @Result(column="usecaselib_relate_team_id",property="libRelateTeamId"),
        @Result(column="usecaselib_creator_id",property="libCreatorId"),
        @Result(column="usecaselib_creator_name",property="libCreatorName")
    })
    @Select("select * from tb_usecaselibrary where usecaselib_id = #{id}")
    public UsecaseLibrary oneUsecaseLibrary(int id);
}
