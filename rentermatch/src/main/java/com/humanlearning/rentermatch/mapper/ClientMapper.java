package com.humanlearning.rentermatch.mapper;

import com.humanlearning.rentermatch.domain.Client;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientMapper {

    //Save the information of new clients into database
    @Insert("INSERT INTO coms4156.client(Name, password, Email) VALUES(#{name},#{password},#{email})")
    int saveClient(@Param("password") String password, @Param("name") String name,
                   @Param("email") String email);

    //Find clients in database by email
    @Select("SELECT cid,Name,password,Email FROM coms4156.client WHERE Email=#{email}")
    Client selectClient(@Param("email") String email);

    @Select("SELECT cid,Name,password,Email FROM coms4156.client WHERE Email=#{email}")
    Client selectClientByEmail(@Param("email") String email);

    @Select("SELECT cid,Name,password,Email FROM coms4156.client WHERE cid=#{cid}")
    Client selectClientBycId(@Param("cid") Integer cid);

    @Delete("DELETE FROM coms4156.client WHERE cid=#{cid}")
    int deleteClientBycId(@Param("cid") Integer cid);
}
