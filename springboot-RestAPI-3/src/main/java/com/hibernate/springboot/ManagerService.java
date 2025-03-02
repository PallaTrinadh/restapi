package com.hibernate.springboot;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import jakarta.transaction.Transactional;

@Service
public class ManagerService 
{
	@Autowired
	private ManagerRepository mns;
	
	public Manager save(Manager mn)
	{
		return mns.save(mn);
	}
	public void DeleteManager(Integer id)
	{
		mns.deleteById(id);
	}
	public Optional<Manager> getbyid(Integer id)
	{
		Optional<Manager> om = mns.findById(id);
		return om;
	}
	public List<Manager> getalls()
	{
		List<Manager> l1 = mns.findAll();
		return l1;
	}
	public Optional<Manager> getbyname(String name)
	{
		Optional<Manager> op = mns.findByName(name);
		return op;
	}
	public Manager updatebyid(Integer id,String name) throws Exception {
		Optional<Manager> s = mns.findById(id);
		if (s != null) {
			Manager s1 = s.get();
			s1.setName(name);
			return mns.save(s1);
		}
		else
		{
			throw new DataIsNoFoundException("data is not avaiable");
		}
	}
	
	

}
