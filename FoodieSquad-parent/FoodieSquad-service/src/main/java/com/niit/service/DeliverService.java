package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.mapper.DeliverMapper;
import com.niit.pojo.Deliver;
@Service
public class DeliverService {
	@Autowired 
	DeliverMapper deliverMapper;
	public	 int deleteByPrimaryKey(Integer deliverId) {
		 return deliverMapper.deleteByPrimaryKey(deliverId);
	 }

	public	 int insert(Deliver record) {
		 return deliverMapper.insert(record);
		 
	 }

	public	 Deliver selectByPrimaryKey(Integer deliverId) {
		 
		 return deliverMapper.selectByPrimaryKey(deliverId);
		 
	 }

	public List<Deliver> selectAll(){
		 
		 return deliverMapper.selectAll();
	 }

	public int updateByPrimaryKey(Deliver record) {
		 
		 return deliverMapper.updateByPrimaryKey(record);
	 }
}
