package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.mapper.HistoryItemMapper;

import com.niit.pojo.HistoryItem;
@Service
public class HistoryService {
	//dishid,orderid(多个),userid(多个)
	//1个orderid多个dishid
	//i个userid 多个orderid
	@Autowired
	private HistoryItemMapper historyItemMapper;

	public List<HistoryItem> selectByOrderId(Integer OrderId){
		return historyItemMapper.selectByOrderId(OrderId);
		
	}
	
	public List<HistoryItem> selectByUserId(Integer UserId){
		return historyItemMapper.selectByUserId(UserId);
	}
	
	public int insertHistoryItemsByOrderId(List<HistoryItem> record) {
		  for(HistoryItem hi:record) {
			  historyItemMapper.insertHistoryItemsByOrderId(hi);
		  }
		return 1;
	}
	
    public int deleteHistoryItemsByOrderId(Integer OrderId) {
    	
    	return historyItemMapper.deleteHistoryItemsByOrderId(OrderId);
    }
	
    public int deleteHistoryItemByUserId(Integer UserId) {
    	
    	return historyItemMapper.deleteHistoryItemByUserId(UserId);
    }
	
}
