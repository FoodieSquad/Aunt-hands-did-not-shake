package com.niit.mapper;

import com.niit.pojo.Window;
import java.util.List;

public interface WindowMapper {
    int deleteByPrimaryKey(Integer windowId);

    int insert(Window record);

    Window selectByPrimaryKey(Integer windowId);
    
    List<Window> selectAll();
    
    List<Window> selectByCanteenId(Integer canteenId);
   
    int updateByPrimaryKey(Window record);
    
    
}