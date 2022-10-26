package com.humanlearning.rentermatch.mapper;

import com.humanlearning.rentermatch.domain.Landlord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface LandlordMapper {

    @Insert("INSERT INTO coms4156.landlord(lPhone, lClientId) VALUES(#{lPhone},#{lClientId})")
    int saveLandlord(@Param("lPhone") String lPhone, @Param("lClientId") Integer lClientId);

    @Select("SELECT lId,lPhone,lClientId FROM coms4156.landlord WHERE lPhone=#{lPhone}")
    Landlord selectLandlord(@Param("lPhone") String lPhone);
}
