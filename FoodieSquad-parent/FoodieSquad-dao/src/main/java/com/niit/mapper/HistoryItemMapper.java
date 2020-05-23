package com.niit.mapper;

import com.niit.pojo.HistoryItem;
import java.util.List;

public interface HistoryItemMapper {
 List<HistoryItem> selectByOrderId(Integer OrderId);
	
 List<HistoryItem> selectByUserId(Integer UserId);
	
int insertHistoryItemsByOrderId(HistoryItem record);
	
int deleteHistoryItemsByOrderId(Integer OrderId);
	
 int deleteHistoryItemByUserId(Integer UserId);
	
}