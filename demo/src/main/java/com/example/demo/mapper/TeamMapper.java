package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.demo.pojo.user.team.Team;

@Mapper
public interface TeamMapper {
    @Insert("insert into tb_team(team_name,team_member_number,creator_id,creator_name) values(#{teamName},#{teamMemberNumber},#{teamManager.userId},#{teamManager.username})")
    public void addTeam(Team newTeam);

    @Select("select team_id from tb_team where team_name = #{teamName} and creator_id = #{teamManager.userId}")
    public int getNewTeamId(Team newTeam);

    @Insert("insert into tb_userteam(user_id,username,team_id,team_name,is_creator,is_member) values(#{teamManager.userId},#{teamManager.username},#{teamId},#{teamName},true,false)")
    public void addCreatorTeam(Team newTeam);

    @Insert("insert into tb_userteam(user_id,username,team_id,team_name) values()")
    public void addUserTeam(Team oneTeam);

    @Results({
        @Result(column="team_id",property="teamId"),
        @Result(column="team_name",property="teamName"),
        @Result(column="team_member_number",property="teamMemberNumber"),
        @Result(column="creator_id",property="teamManager.userId"),
        @Result(column="creator_name",property="teamManager.username")
    })
    @Select("select * from tb_team where creator_id=#{id}")
    public Team getTeamInfo(int id);
}
