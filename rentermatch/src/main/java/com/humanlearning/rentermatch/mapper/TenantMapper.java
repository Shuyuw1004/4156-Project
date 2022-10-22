package com.humanlearning.rentermatch.mapper;

import com.humanlearning.rentermatch.domain.Tenant;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantMapper {
    @Insert("INSERT INTO coms4156.tenant(tid, tAge, tClientId, tConstellation, tCooking, tEarlyTimeSleep, tExpenditure, tGender, tJob, tLateTimeSleep, tNumOfRoomates, tPet, tPhone, tPreferLocation, tPreferType, tPreferZipCode, tSmoking) VALUES(#{tId},#{tAge},#{tClientId},#{tConstellation},#{tCooking},#{tEarlyTimeSleep},#{tExpenditure},#{tGender},#{tJob},#{tLateTimeSleep},#{tNumOfRoomates},#{tPet},#{tPhone},#{tpreferLocation},#{tPreferType},#{tPreferZipCode},#{tSmoking})")
    int saveTenant(@Param("tid") String tid, @Param("tAge") Integer tAge, @Param("tClientId") String tClientId, @Param("tConstellation") String tConstellation, @Param("tCooking") String tCooking, @Param("tEarlyTimeSleep") String tEarlyTimeSleep, @Param("tExpenditure") Integer tExpenditure, @Param("tGender") String tGender, @Param("tJob") String tJob, @Param("tLateTimeSleep") String tLateTimeSleep, @Param("tNumOfRoomates") Integer tNumOfRoomates, @Param("tPet") String tPet, @Param("tPhone") String tPhone, @Param("tPreferLocation") String tPreferLocation, @Param("tPreferType") String tPreferType, @Param("tPreferZipCode") String tPreferZipCode, @Param("tSmoking") String tSmoking);

    @Select("SELECT tid, tAge, tClientId, tConstellation, tCooking, tEarlyTimeSleep, tExpenditure, tGender, tJob, tLateTimeSleep, tMatches, tNumOfRoomates, tPet, tPhone, tPreferLocation, tPreferType, tPreferZipCode, tSmoking FROM coms4156.tenant WHERE tid=#{tid}")
    Tenant selectTenant(@Param("tid") String tid);

}
