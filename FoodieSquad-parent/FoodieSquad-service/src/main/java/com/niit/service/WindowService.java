package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.mapper.WindowMapper;
import com.niit.pojo.Window;
@Service
public class WindowService {
	@Autowired 
	private WindowMapper windowMapper;
	public  int deleteByPrimaryKey(Integer windowId) {
		  return windowMapper.deleteByPrimaryKey(windowId);
	  }

	public    int insert(Window record) {
	    	return windowMapper.insert(record);
	    }

	public    Window selectByPrimaryKey(Integer windowId) {
	    	return windowMapper.selectByPrimaryKey(windowId);
	    }
	    
	public   List<Window> selectAll(){
	    	return windowMapper.selectAll();
	    	}
	    
	public   List<Window> selectByCanteenId(Integer canteenId){
	    	return windowMapper.selectByCanteenId(canteenId);
	    }
	   
	public   int updateByPrimaryKey(Window record) {
	    	
	    	return windowMapper.updateByPrimaryKey(record);
	    }
}
