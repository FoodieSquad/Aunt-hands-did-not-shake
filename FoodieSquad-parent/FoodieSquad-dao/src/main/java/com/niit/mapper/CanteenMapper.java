package com.niit.mapper;

import com.niit.pojo.Canteen;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CanteenMapper {
    int deleteByPrimaryKey(Integer canteenId);

    int insert(Canteen record);

    Canteen selectByPrimaryKey(Integer canteenId);

    List<Canteen> selectAll();

    int updateByPrimaryKey(Canteen record);

	List<Canteen> searchCanteenByName(@Param("name") String name);
}