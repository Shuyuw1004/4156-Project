package com.humanlearning.rentermatch.mapper;

import com.humanlearning.rentermatch.domain.Tenant;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantMapper {

  @Insert(
      "INSERT INTO coms4156.tenant(tAge, tClientId, tConstellation, tCooking, tEarlyTimeSleep, tExpenditure, tGender, "
          +
          "tJob, tLateTimeSleep, tNumOfRoomates, tPet, tPhone, tPreferLocation, tPreferType, tPreferZipCode, tSmoking) "
          +
          "VALUES(#{tAge},#{tClientId},#{tConstellation},#{tCooking},#{tEarlyTimeSleep},#{tExpenditure},#{tGender},#{tJob},"
          +
          "#{tLateTimeSleep},#{tNumOfRoomates},#{tPet},#{tPhone},#{tPreferLocation},#{tPreferType},#{tPreferZipCode},#{tSmoking})")
  Integer saveTenant(@Param("tAge") Integer tAge,
      @Param("tClientId") String tClientId, @Param("tConstellation") String tConstellation,
      @Param("tCooking") String tCooking, @Param("tEarlyTimeSleep") String tEarlyTimeSleep,
      @Param("tExpenditure") Integer tExpenditure, @Param("tGender") String tGender,
      @Param("tJob") String tJob, @Param("tLateTimeSleep") String tLateTimeSleep,
      @Param("tNumOfRoomates") Integer tNumOfRoomates, @Param("tPet") String tPet,
      @Param("tPhone") String tPhone, @Param("tPreferLocation") String tPreferLocation,
      @Param("tPreferType") String tPreferType, @Param("tPreferZipCode") String tPreferZipCode,
      @Param("tSmoking") String tSmoking);

  @Select(
      "SELECT tid, tAge, tClientId, tConstellation, tCooking, tEarlyTimeSleep, tExpenditure, tGender, tJob, tLateTimeSleep, "
          +
          "tMatches, tNumOfRoomates, tPet, tPhone, tPreferLocation, tPreferType, tPreferZipCode, tSmoking FROM coms4156.tenant WHERE tid=#{tid}")
  Tenant selectTenantBytId(@Param("tid") String tid);

  @Select(
      "SELECT tid, tAge, tClientId, tConstellation, tCooking, tEarlyTimeSleep, tExpenditure, tGender, tJob, tLateTimeSleep, "
          +
          "tMatches, tNumOfRoomates,tPet,tNumOfRoomates, tPhone, tPreferLocation, tPreferType, tPreferZipCode, tSmoking "
          +
          "FROM coms4156.tenant WHERE tClientId=#{tClientId}")
  Tenant selectTenantBytClientId(@Param("tClientId") String tClientId);

  @Update(
      "UPDATE coms4156.tenant SET tAge = #{tAge}, tConstellation = #{tConstellation}, tCooking = #{tCooking}, "
          +
          "tEarlyTimeSleep = #{tEarlyTimeSleep}, tExpenditure = #{tExpenditure}, tGender = #{tGender}, tJob = #{tJob}, "
          +
          "tLateTimeSleep = #{tLateTimeSleep}, tNumOfRoomates = #{tNumOfRoomates}, tPet = #{tPet}, tPhone = #{tPhone}, tPreferLocation = #{tPreferLocation}, "
          +
          "tPreferType = #{tPreferType}, tPreferZipCode = #{tPreferZipCode}, tSmoking = #{tSmoking} WHERE tClientId = #{tClientId}")
  Integer updateTenant(@Param("tAge") Integer tAge,
      @Param("tClientId") String tClientId, @Param("tConstellation") String tConstellation,
      @Param("tCooking") String tCooking, @Param("tEarlyTimeSleep") String tEarlyTimeSleep,
      @Param("tExpenditure") Integer tExpenditure, @Param("tGender") String tGender,
      @Param("tJob") String tJob, @Param("tLateTimeSleep") String tLateTimeSleep,
      @Param("tNumOfRoomates") Integer tNumOfRoomates, @Param("tPet") String tPet,
      @Param("tPhone") String tPhone, @Param("tPreferLocation") String tPreferLocation,
      @Param("tPreferType") String tPreferType, @Param("tPreferZipCode") String tPreferZipCode,
      @Param("tSmoking") String tSmoking);

  @Delete("DELETE FROM coms4156.tenant WHERE tClientId=#{tClientId}")
  int deleteTenantBytClientId(@Param("tClientId") String tClientId);

  //    @Select("SELECT tClientId, tPhone FROM coms4156.tenant WHERE tConstellation = #{tConstellation} AND tCooking = #{tCooking} AND " +
//            "tEarlyTimeSleep = #{tEarlyTimeSleep} AND tExpenditure = #{tExpenditure} AND tGender = #{tGender} AND tJob = #{tJob} AND " +
//            "tLateTimeSleep = #{tLateTimeSleep} AND tNumOfRoomates = #{tNumOfRoomates} AND tPet = #{tPet} AND tPreferLocation = #{tPreferLocation} AND " +
//            "tPreferType = #{tPreferType} AND tPreferZipCode = #{tPreferZipCode} AND tSmoking = #{tSmoking} AND tClientId != tClientId")
  @Select(
      "SELECT tid, tAge, tClientId, tConstellation, tCooking, tEarlyTimeSleep, tExpenditure, tGender, tJob, tLateTimeSleep, "
          +
          "tMatches, tNumOfRoomates, tPet, tPhone, tPreferLocation, tPreferType, tPreferZipCode, tSmoking FROM coms4156.tenant "
          +
          "WHERE tConstellation = #{tConstellation} AND tCooking = #{tCooking} AND tEarlyTimeSleep = #{tEarlyTimeSleep} AND "
          +
          "tExpenditure = #{tExpenditure} AND tGender = #{tGender} AND tJob = #{tJob} AND tLateTimeSleep = #{tLateTimeSleep} AND "
          +
          "tNumOfRoomates = #{tNumOfRoomates} AND tPet = #{tPet} AND tPreferLocation = #{tPreferLocation} AND tPreferType = #{tPreferType} AND "
          +
          "tPreferZipCode = #{tPreferZipCode} AND tSmoking = #{tSmoking} AND tClientId != #{tClientId}")
  List<Tenant> getMatch(@Param("tClientId") String tClientId,
      @Param("tConstellation") String tConstellation,
      @Param("tCooking") String tCooking, @Param("tEarlyTimeSleep") String tEarlyTimeSleep,
      @Param("tExpenditure") Integer tExpenditure, @Param("tGender") String tGender,
      @Param("tJob") String tJob, @Param("tLateTimeSleep") String tLateTimeSleep,
      @Param("tNumOfRoomates") Integer tNumOfRoomates, @Param("tPet") String tPet,
      @Param("tPreferLocation") String tPreferLocation, @Param("tPreferType") String tPreferType,
      @Param("tPreferZipCode") String tPreferZipCode, @Param("tSmoking") String tSmoking);
}
