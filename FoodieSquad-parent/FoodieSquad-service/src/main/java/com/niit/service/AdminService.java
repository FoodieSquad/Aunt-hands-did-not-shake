package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.mapper.AdminMapper;
import com.niit.pojo.Admin;

@Service
public class AdminService {
@Autowired
private AdminMapper adminMapper;
public int deleteByPrimaryKey(Integer adminId) {
	return adminMapper.deleteByPrimaryKey(adminId);
	}

public int insert(Admin record) {
	return adminMapper.insert(record);
	
}

public Admin selectByPrimaryKey(Integer adminId) {
	return adminMapper.selectByPrimaryKey(adminId);
	
}

public List<Admin> selectAll(){
	return adminMapper.selectAll();
}

public int updateByPrimaryKey(Admin record) {
	return adminMapper.updateByPrimaryKey(record);
}
}
