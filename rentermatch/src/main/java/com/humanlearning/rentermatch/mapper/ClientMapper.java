package com.humanlearning.rentermatch.mapper;

import com.humanlearning.rentermatch.domain.Client;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientMapper {
    @Insert("INSERT INTO coms4156.client(Name, password, Email) VALUES(#{name},#{password},#{email})")
    int saveClient(@Param("password") String password, @Param("name") String name, @Param("email") String email);

    @Select("SELECT cid,Name,password,Email FROM coms4156.client WHERE Email=#{email}")
    Client selectClient(@Param("email") String email);
}
