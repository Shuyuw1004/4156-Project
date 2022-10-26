package com.humanlearning.rentermatch.mapper;

import com.humanlearning.rentermatch.domain.House;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseMapper {

    @Insert("INSERT INTO coms4156.house(hAddress, hPrice, hType, hLandlordId) VALUES(#{hAddress},#{hPrice},#{hType},#{hLandlordId})")
    int saveHouse(@Param("hAddress") String hAddress, @Param("hPrice") Integer hPrice, @Param("hType") String hType, @Param("hLandlordId") Integer hLandlordId);

    @Select("SELECT hId,hAddress,hPrice,hType,hLandlordId FROM coms4156.house WHERE hAddress=#{hAddress}")
    House selectHouse(@Param("hAddress") String hAddress);
}
