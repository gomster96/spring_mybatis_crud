package com.mybatis.aancrud.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.mybatis.aancrud.beans.*;

@Service
public interface EmpService{
	public Emp getEmpById(int id);
	public List<Emp> getEmpList();
	public int saveEmp(Emp p);
	public int updateEmp(Emp p);
	public int deleteEmp(int id);
	
}