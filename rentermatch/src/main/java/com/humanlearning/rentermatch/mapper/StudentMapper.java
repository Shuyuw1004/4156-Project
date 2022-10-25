package com.humanlearning.rentermatch.mapper;

import com.humanlearning.rentermatch.domain.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapper {

  @Insert("INSERT INTO coms4156.student(email, name, sid, uni) VALUES(#{email},#{name},#{sid},#{uni})")
  int saveStudent(@Param("email") String email, @Param("name") String name,
      @Param("sid") Integer sid, @Param("uni") String uni);
//    Assume students know their sid after register?

  @Select("SELECT email,name,sid,uni FROM coms4156.student WHERE name=#{name}")
  Student selectStudent(@Param("name") String name);
}
