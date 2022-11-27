package com.humanlearning.rentermatch.mapper;

import com.humanlearning.rentermatch.domain.Landlord;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface LandlordMapper {

    @Insert("INSERT INTO coms4156.landlord(lPhone, lClientId) VALUES(#{lPhone},#{lClientId})")
    int saveLandlord(@Param("lPhone") String lPhone, @Param("lClientId") Integer lClientId);

    @Select("SELECT lId,lPhone,lClientId FROM coms4156.landlord WHERE lClientId=#{lClientId}")
    Landlord selectLandlordBylClientId(@Param("lClientId") Integer lClientId);

    @Select("SELECT lId,lPhone,lClientId FROM coms4156.landlord WHERE lId=#{lId}")
    Landlord selectLandlordBylId(@Param("lId") Integer lId);

    @Update("UPDATE coms4156.landlord SET lPhone= #{lPhone}, lClientId = #{lClientId} WHERE lId = #{lId}")
    int updateLandlord(@Param("lPhone") String lPhone, @Param("lClientId") Integer lClientId, @Param("lId") Integer lId);

    @Delete("DELETE FROM coms4156.landlord WHERE lId=#{lId}")
    int deleteLandlordBylId(@Param("lId") Integer lId);
}
