package com.niit.mapper;

import com.niit.pojo.Deliver;
import java.util.List;

public interface DeliverMapper {
    int deleteByPrimaryKey(Integer deliverId);

    int insert(Deliver record);

    Deliver selectByPrimaryKey(Integer deliverId);

    List<Deliver> selectAll();

    int updateByPrimaryKey(Deliver record);
}