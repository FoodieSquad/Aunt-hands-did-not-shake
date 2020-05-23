package com.niit.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.mapper.CanteenMapper;
import com.niit.pojo.Canteen;
@Service
public class CanteenService {
	@Autowired
	private CanteenMapper canteenMapper;
public	int deleteByPrimaryKey(Integer canteenId) {
		return canteenMapper.deleteByPrimaryKey(canteenId);
	}

public    int insert(Canteen record) {
	return canteenMapper.insert(record);
}

public  Canteen selectByPrimaryKey(Integer canteenId) {
    	return canteenMapper.selectByPrimaryKey(canteenId);
    	
    }

public   List<Canteen> selectAll(){
    	return canteenMapper.selectAll();
    }

    public    int updateByPrimaryKey(Canteen record){
    	return canteenMapper.updateByPrimaryKey(record);
    }
 
    
    public  List<Canteen> searchCanteenByName( String name){
    	
    		return canteenMapper.searchCanteenByName(name);
    	
    	
    	
    }
}
