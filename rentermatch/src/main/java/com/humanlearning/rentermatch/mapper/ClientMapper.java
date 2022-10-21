package com.humanlearning.rentermatch.mapper;

import com.humanlearning.rentermatch.domain.Client;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientMapper {
    @Insert("INSERT INTO coms4156.client(name, password) VALUES(#{name},#{password})")
    int saveClient(@Param("name") String name, @Param("password") String password);

    @Select("SELECT cid,name,password FROM coms4156.client WHERE name=#{name}")
    Client selectClient(@Param("name") String name);
}
