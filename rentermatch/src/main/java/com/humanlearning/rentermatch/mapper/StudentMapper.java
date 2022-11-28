package com.humanlearning.rentermatch.mapper;

import com.humanlearning.rentermatch.domain.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapper {
    @Insert("INSERT INTO coms4156.student(email, name, sClientId, uni) VALUES(#{email},#{name},#{sClientId},#{uni})")
    int saveStudent(@Param("email") String email, @Param("name") String name, @Param("sClientId") String sClientId, @Param("uni") String uni);

    @Select("SELECT email,name,sid,sClientId,uni FROM coms4156.student WHERE name=#{name}")
    Student selectStudent(@Param("name") String name);

    @Select("SELECT email, name, sid, sClientId, uni FROM coms4156.student WHERE uni=#{uni}")
    Student selectStudentByuni(@Param("uni") String uni);

    @Select("SELECT email, name, sid, sClientId, uni FROM coms4156.student WHERE sid=#{sid}")
    Student selectStudentBysid(@Param("sid") String sid);

    @Select("SELECT email, name, sid, sClientId, uni FROM coms4156.student WHERE email=#{email}")
    Student selectStudentByemail(@Param("email") String email);

    @Select("SELECT email, name, sid, sClientId, uni FROM coms4156.student WHERE sClientId=#{sClientId}")
    Student selectStudentBysClientId(@Param("sClientId") String sClientId);

    @Select("SELECT email,name,sid,sClientId,uni FROM coms4156.student WHERE name=#{name}")
    Student selectStudentByname(@Param("name") String name);

    @Delete("DELETE FROM coms4156.student WHERE sClientId=#{sClientId}")
    int deleteStudentBysClientId(@Param("sClientId") String sClientId);

    @Update("UPDATE coms4156.student SET email = #{email}, name = #{name}, uni = #{uni} WHERE sClientId = #{sClientId}")
    int updateStudent(@Param("sClientId") String sClientId, @Param("email") String email, @Param("name") String name, @Param("uni") String uni);

}
