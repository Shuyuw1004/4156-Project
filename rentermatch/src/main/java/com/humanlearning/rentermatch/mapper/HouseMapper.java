package com.humanlearning.rentermatch.mapper;

import com.humanlearning.rentermatch.domain.House;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseMapper {

    @Insert("INSERT INTO coms4156.house(hAddress, hPrice, hType, hLandlordId) VALUES(#{hAddress},#{hPrice},#{hType},#{hLandlordId})")
    int saveHouse(@Param("hAddress") String hAddress, @Param("hPrice") Integer hPrice, @Param("hType") String hType, @Param("hLandlordId") Integer hLandlordId);

    @Select("SELECT hId,hAddress,hPrice,hType,hLandlordId FROM coms4156.house WHERE hAddress=#{hAddress}")
    House selectHouse(@Param("hAddress") String hAddress);

    @Update("UPDATE coms4156.house SET hAddress= #{hAddress}, hPrice = #{hPrice}, hType = #{hType}, hLandlordId = #{hLandlordId} WHERE hId = #{hId}")
    int updateHouse(@Param("hId") Integer hId, @Param("hAddress") String hAddress, @Param("hPrice") Integer hPrice, @Param("hType") String hType, @Param("hLandlordId") Integer hLandlordId);

    @Delete("DELETE FROM coms4156.house WHERE hId=#{hId}")
    int deleteHouseByhId(@Param("hId") Integer hId);
}
