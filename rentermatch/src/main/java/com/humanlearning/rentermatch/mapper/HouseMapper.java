package com.humanlearning.rentermatch.mapper;

import com.humanlearning.rentermatch.domain.House;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseMapper {

    @Insert("INSERT INTO coms4156.house(hAddress, hPrice, hType, hLandlordId) VALUES(#{hAddress},#{hPrice},#{hType},#{hLandlordId})")
    int saveHouse(@Param("hAddress") String hAddress, @Param("hPrice") Integer hPrice, @Param("hType") String hType, @Param("hLandlordId") String hLandlordId);

    @Select("SELECT hId,hAddress,hPrice,hType,hLandlordId FROM coms4156.house WHERE hAddress=#{hAddress}")
    House selectHouse(@Param("hAddress") String hAddress);

    @Update("UPDATE coms4156.house SET hPrice = #{hPrice} WHERE hAddress = #{hAddress} ")
    int updateHousePrice(@Param("hAddress") String hAddress, @Param("hPrice") Integer hPrice);

    @Delete("DELETE FROM coms4156.house WHERE hAddress=#{hAddress}")
    int deleteHouseByhAddress(@Param("hAddress") String hAddress);

    @Delete("DELETE FROM coms4156.house WHERE hLandlordId=#{hLandlordId}")
    int deleteHouseByhLandlordId(@Param("hLandlordId") String hLandlordId);

}
